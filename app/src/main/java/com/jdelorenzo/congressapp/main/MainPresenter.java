package com.jdelorenzo.congressapp.main;

import android.util.Log;

import com.jdelorenzo.congressapp.model.Legislator;
import com.jdelorenzo.congressapp.model.LegislatorResult;
import com.jdelorenzo.congressapp.network.SunlightCongressEndpoint;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements MainContract.Presenter {
    private final SunlightCongressEndpoint endpoint;
    private final MainContract.View mainView;
    private static final String LOG_TAG = MainPresenter.class.getSimpleName();

    @Inject
    MainPresenter(SunlightCongressEndpoint endpoint, MainContract.View mainView) {
        this.endpoint = endpoint;
        this.mainView = mainView;
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
                Log.e(LOG_TAG, "Call to retrieve legislators failed.");
            }
        });
    }

    @Override
    public void performSearch(int zipCode) {
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
                Log.e(LOG_TAG, "Call to retrieve legislators failed.");
            }
        });
    }
}
