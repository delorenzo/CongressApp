package com.jdelorenzo.congressapp.main;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.text.TextUtilsCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.jdelorenzo.congressapp.CongressApplication;
import com.jdelorenzo.congressapp.R;
import com.jdelorenzo.congressapp.adapters.LegislatorAdapter;
import com.jdelorenzo.congressapp.model.Legislator;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainContract.View {
    @Inject MainPresenter mainPresenter;
    @BindView(R.id.legislator_list) RecyclerView legislatorListView;
    @BindView(R.id.legislator_list_empty_view) TextView legislatorEmptyView;
    @BindView(R.id.progress_bar) ProgressBar progressBar;
    private LegislatorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DaggerMainComponent.builder()
                .mainPresenterModule(new MainPresenterModule(this))
                .netComponent(((CongressApplication)getApplication()).getNetComponent())
                .build()
                .inject(this);
        adapter = new LegislatorAdapter(this, legislatorEmptyView);
        legislatorListView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        legislatorListView.setAdapter(adapter);
        mainPresenter.getAllLegislators();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
             try {
                 int zipCode = Integer.parseInt(query);
                 mainPresenter.performSearch(zipCode);
             } catch (NumberFormatException e) {
                 Toast.makeText(this, "Not a valid zip code.", Toast.LENGTH_SHORT).show();
             }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
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
}
