package com.jdelorenzo.congressapp.main;

import com.jdelorenzo.congressapp.ActivityScope;
import com.jdelorenzo.congressapp.network.NetComponent;

import dagger.Component;

@ActivityScope
@Component(dependencies= NetComponent.class, modules=MainPresenterModule.class)
public interface MainComponent {
    void inject(MainActivity activity);
}
