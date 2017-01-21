package com.jdelorenzo.congressapp;

import android.content.SharedPreferences;

import com.jdelorenzo.congressapp.settings.CongressPreferenceFragment;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(CongressPreferenceFragment fragment);
}
