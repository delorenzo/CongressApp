package com.jdelorenzo.congressapp.settings;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.support.annotation.NonNull;

import com.jdelorenzo.congressapp.CongressApplication;
import com.jdelorenzo.congressapp.R;

import javax.inject.Inject;

/** PreferenceActivity is deprecated, requiring this Fragment boilerplate. */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class CongressPreferenceFragment extends android.preference.PreferenceFragment {
  private static Preference.OnPreferenceChangeListener preferenceChangeListener =
      new Preference.OnPreferenceChangeListener() {
        @Override
        public boolean onPreferenceChange(Preference preference, Object newValue) {
          String displayValue = newValue.toString();
          // a ListPreference's display label may differ from the value stored
          if (preference instanceof ListPreference) {
            ListPreference listPreference = (ListPreference) preference;
            int labelIndex = listPreference.findIndexOfValue(displayValue);
            displayValue = listPreference.getEntries()[labelIndex].toString();
          }
          preference.setSummary(displayValue);
          return true;
        }
      };
  @Inject SharedPreferences sharedPreferences;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ((CongressApplication) (getActivity().getApplication())).getAppComponent().inject(this);
    addPreferencesFromResource(R.xml.preferences);
    setHasOptionsMenu(true);
    bindPreferenceSummaryToValue(findPreference(getString(R.string.shared_pref_key_zipcode)));
  }

  private void bindPreferenceSummaryToValue(@NonNull Preference preference) {
    preference.setOnPreferenceChangeListener(preferenceChangeListener);
    if (preference instanceof CheckBoxPreference) {
      preferenceChangeListener.onPreferenceChange(
          preference, sharedPreferences.getBoolean(preference.getKey(), false));
    } else {
      preferenceChangeListener.onPreferenceChange(
          preference, sharedPreferences.getString(preference.getKey(), ""));
    }
  }
}
