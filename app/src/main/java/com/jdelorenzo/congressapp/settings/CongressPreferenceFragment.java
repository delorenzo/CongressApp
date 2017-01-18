package com.jdelorenzo.congressapp.settings;

import android.app.Fragment;
import android.os.Bundle;

import com.jdelorenzo.congressapp.R;

/**
 * PreferenceActivity is deprecated, requiring this Fragment boilerplate..
 */

public class CongressPreferenceFragment extends android.preference.PreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }
}
