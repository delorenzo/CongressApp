package com.jdelorenzo.congressapp.pager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jdelorenzo.congressapp.ui.legislators.list.LegislatorFilter;

/**
 * {@link PagerAdapter} that uses Views instead of Fragments.
 */

public class FragmentlessPagerAdapter extends PagerAdapter {
    private Context context;

    public FragmentlessPagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public void startUpdate(ViewGroup container) {
        super.startUpdate(container);
    }



    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LegislatorFilter legislatorPagerEnum = LegislatorFilter.values()[position];
        ViewGroup layout = (ViewGroup) LayoutInflater.from(context)
                .inflate(legislatorPagerEnum.getLayoutId(), container, false);
        container.addView(layout);
        return layout;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return LegislatorFilter.values().length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public CharSequence getPageTitle(int position) {
         return context.getString(LegislatorFilter.values()[position].getTitleId());
    }
}
