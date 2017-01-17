package com.jdelorenzo.congressapp.legislators;

import com.jdelorenzo.congressapp.ActivityScope;
import com.jdelorenzo.congressapp.AppModule;
import com.jdelorenzo.congressapp.FragmentScope;
import com.jdelorenzo.congressapp.network.NetComponent;

import dagger.Component;

@FragmentScope
@Component(dependencies=NetComponent.class, modules={LegislatorsPresenterModule.class})
public interface LegislatorsComponent {
    void inject(LegislatorsFragment fragment);
}
