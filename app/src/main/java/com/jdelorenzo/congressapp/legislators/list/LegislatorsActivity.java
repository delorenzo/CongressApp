package com.jdelorenzo.congressapp.legislators.list;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;

import com.jdelorenzo.congressapp.R;
import com.jdelorenzo.congressapp.settings.AppCompatPreferenceActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LegislatorsActivity extends AppCompatActivity {
    @BindView(R.id.pager) ViewPager viewPager;
    @BindView(R.id.progress_bar) ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_legislators);
        ButterKnife.bind(this);
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
             @Override
             public Fragment getItem(int position) {
                 return LegislatorsFragment.newInstance(LegislatorFilter.values()[position]);
             }

             @Override
             public int getCount() {
                 return LegislatorFilter.values().length;
             }

            @Override
            public CharSequence getPageTitle(int position) {
                int titleResource = LegislatorFilter.values()[position].getTitleId();
                return getString(titleResource);
            }
        });
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, AppCompatPreferenceActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
