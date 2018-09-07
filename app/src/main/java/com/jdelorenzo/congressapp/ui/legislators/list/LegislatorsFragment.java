package com.jdelorenzo.congressapp.ui.legislators.list;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.jdelorenzo.congressapp.CongressApplication;
import com.jdelorenzo.congressapp.R;
import com.jdelorenzo.congressapp.data.model.Legislator;
import com.jdelorenzo.congressapp.ui.legislators.LegislatorViewModel;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public final class LegislatorsFragment extends Fragment implements LegislatorsContract.View {
  private static final String ARG_FILTER = "filter";
  @Inject LegislatorsPresenter legislatorsPresenter;

  @BindView(R.id.legislator_list)
  RecyclerView legislatorListView;

  @BindView(R.id.legislator_list_empty_view)
  TextView legislatorEmptyView;

  @BindView(R.id.progress_bar)
  ProgressBar progressBar;

  private LegislatorAdapter adapter;
  private LegislatorsPresenter mPresenter;
  private LegislatorViewModel legislatorViewModel;
  private Unbinder unbinder;

  public static LegislatorsFragment newInstance(LegislatorFilter filter) {
    LegislatorsFragment fragment = new LegislatorsFragment();
    Bundle b = new Bundle();
    b.putSerializable(ARG_FILTER, filter);
    fragment.setArguments(b);
    return fragment;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    DaggerLegislatorsComponent.builder()
        .legislatorsPresenterModule(new LegislatorsPresenterModule(this))
        .netComponent(
            ((CongressApplication) getContext().getApplicationContext()).getNetComponent())
        .build()
        .inject(this);
    legislatorViewModel = ViewModelProviders.of(this).get(LegislatorViewModel.class);
    legislatorViewModel.getLegislators().observe(this, (@Nullable List<Legislator> legislators) ->  {
        adapter.setItems(legislators);
    });
  }

  @Nullable
  @Override
  public View onCreateView(
      LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.legislator_list, container, false);
    unbinder = ButterKnife.bind(this, rootView);
    adapter =
        new LegislatorAdapter(
            getActivity(),
            legislatorEmptyView,
            new LegislatorAdapter.LegislatorAdapterOnClickHandler() {
              @Override
              public void onClick(Legislator legislator) {
                legislatorsPresenter.onLegislatorSelected(legislator);
              }
            });
    legislatorListView.setLayoutManager(new LinearLayoutManager(getActivity()));
    legislatorListView.setAdapter(adapter);
    Bundle args = getArguments();
    if (args.containsKey(ARG_FILTER)) {
      legislatorsPresenter.getLegislatorsByFilter(
          (LegislatorFilter) args.getSerializable(ARG_FILTER));
    }
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

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    unbinder.unbind();
  }
}
