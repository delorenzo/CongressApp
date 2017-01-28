package com.jdelorenzo.congressapp.legislators.list;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

import com.jdelorenzo.congressapp.R;
import com.jdelorenzo.congressapp.legislators.detail.LegislatorDetailActivity;
import com.jdelorenzo.congressapp.model.Legislator;
import com.jdelorenzo.congressapp.model.LegislatorResult;
import com.jdelorenzo.congressapp.network.SunlightCongressEndpoint;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

class LegislatorsPresenter implements LegislatorsContract.Presenter {
    private final Context context;
    private final SunlightCongressEndpoint endpoint;
    private final LegislatorsContract.View mainView;
    private final SharedPreferences sharedPreferences;
    private static final String LOG_TAG = LegislatorsPresenter.class.getSimpleName();

    @Inject
    LegislatorsPresenter(SunlightCongressEndpoint endpoint,
                         LegislatorsContract.View mainView,
                         Context context,
                         SharedPreferences sharedPreferences) {
        this.endpoint = endpoint;
        this.mainView = mainView;
        this.context = context;
        this.sharedPreferences = sharedPreferences;
    }

    @Override
    public void getLegislatorsByFilter(LegislatorFilter filter) {
        switch (filter) {
            case MY:
                getMyLegislators();
                break;
            case ALL:
            default:
                getAllLegislators();
                break;
        }
    }

    @Override
    public void getMyLegislators() {
        int zipCode = Integer.parseInt(
                sharedPreferences.getString(
                        context.getString(R.string.shared_pref_key_zipcode),
                        "0"));
        getLegislatorsByZip(zipCode);
    }

    @Override
    public void getAllLegislators() {
        mainView.showLoadingIndicator();
        endpoint.getAllLegislators().enqueue(new Callback<LegislatorResult>() {
            @Override
            public void onResponse(Call<LegislatorResult> call, Response<LegislatorResult> response) {
                mainView.hideLoadingIndicator();
                if (response.isSuccessful()) {
                    mainView.displaySearchResults(response.body().results);
                } else {
                    Log.e(LOG_TAG, "Bad response:  " + response.code());
                }
            }

            @Override
            public void onFailure(Call<LegislatorResult> call, Throwable t) {
                mainView.hideLoadingIndicator();
                Log.e(LOG_TAG, "Call to retrieve legislators failed:  "+ t.getLocalizedMessage());
            }
        });
    }

    @Override
    public void getLegislatorsByZip(int zipCode) {
        mainView.showLoadingIndicator();
        endpoint.getLegislatorsByZip(zipCode).enqueue(new Callback<LegislatorResult>() {
            @Override
            public void onResponse(Call<LegislatorResult> call, Response<LegislatorResult> response) {
                mainView.hideLoadingIndicator();
                if (response.isSuccessful()) {
                    mainView.displaySearchResults(response.body().results);
                } else {
                    Log.e(LOG_TAG, "Bad response:  " + response.code());
                }
            }

            @Override
            public void onFailure(Call<LegislatorResult> call, Throwable t) {
                mainView.hideLoadingIndicator();
                Log.e(LOG_TAG, "Call to retrieve legislators failed:  " + t.getLocalizedMessage());
            }
        });
    }

    @Override
    public void onLegislatorSelected(Legislator legislator) {
        Intent intent = new Intent(context, LegislatorDetailActivity.class);
        intent.putExtra(LegislatorDetailActivity.EXTRA_LEGISLATOR, legislator);
        context.startActivity(intent);
    }
}
