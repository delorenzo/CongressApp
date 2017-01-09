package com.jdelorenzo.congressapp.network;

import com.jdelorenzo.congressapp.AppModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {
    SunlightCongressEndpoint provideEndpoint();
}
