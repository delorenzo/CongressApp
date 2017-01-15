package com.jdelorenzo.congressapp.legislators;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.jdelorenzo.congressapp.CongressApplication;
import com.jdelorenzo.congressapp.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LegislatorsActivity extends AppCompatActivity {
    @BindView(R.id.pager) ViewPager viewPager;
    @Inject LegislatorsPresenter legislatorsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_legislators);
        ButterKnife.bind(this);
        LegislatorsFragment fragment = (LegislatorsFragment) getFragmentManager().findFragmentById(R.id.fragment_legislator_list);
        if (fragment == null) {
            fragment = new LegislatorsFragment();
            getFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, fragment)
                    .commit();
        }
        DaggerLegislatorsComponent.builder()
                .legislatorsPresenterModule(new LegislatorsPresenterModule(fragment))
                .netComponent(((CongressApplication)getApplication()).getNetComponent())
                .build()
                .inject(this);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
//            String query = intent.getStringExtra(SearchManager.QUERY);
//             try {
//                 int zipCode = Integer.parseInt(query);
//                 mainPresenter.getLegislatorsByZip(zipCode);
//             } catch (NumberFormatException e) {
//                 Toast.makeText(this, "Not a valid zip code.", Toast.LENGTH_SHORT).show();
//             }
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


}
