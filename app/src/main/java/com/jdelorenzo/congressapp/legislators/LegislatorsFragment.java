package com.jdelorenzo.congressapp.legislators;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.jdelorenzo.congressapp.R;
import com.jdelorenzo.congressapp.model.Legislator;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public final class LegislatorsFragment extends Fragment implements LegislatorsContract.View {
    @Inject LegislatorsPresenter legislatorsPresenter;
    @BindView(R.id.legislator_list) RecyclerView legislatorListView;
    @BindView(R.id.legislator_list_empty_view) TextView legislatorEmptyView;
    @BindView(R.id.progress_bar) ProgressBar progressBar;
    private LegislatorAdapter adapter;
    private LegislatorsPresenter mPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new LegislatorAdapter(getActivity(), legislatorEmptyView);
        legislatorListView.setLayoutManager(new LinearLayoutManager(getActivity()));
        legislatorListView.setAdapter(adapter);
        legislatorsPresenter.getAllLegislators();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.legislator_list, container, false);

        return rootView;
    }

    @Override
    public void displaySearchResults(List<Legislator> results) {
        adapter.setItems(results);
    }

    @Override
    public void showLoadingIndicator() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoadingIndicator() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    public void setPresenter(@NonNull LegislatorsPresenter legislatorsPresenter) {
        this.legislatorsPresenter = legislatorsPresenter;
    }
}
