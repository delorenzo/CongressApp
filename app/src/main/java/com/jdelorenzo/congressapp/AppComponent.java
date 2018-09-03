package com.jdelorenzo.congressapp;

import com.jdelorenzo.congressapp.settings.CongressPreferenceFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
  void inject(CongressPreferenceFragment fragment);
}
