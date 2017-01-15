package com.jdelorenzo.congressapp.legislators;

import com.jdelorenzo.congressapp.ActivityScope;
import com.jdelorenzo.congressapp.network.NetComponent;

import dagger.Component;

@ActivityScope
@Component(dependencies= NetComponent.class, modules=LegislatorsPresenterModule.class)
public interface LegislatorsComponent {
    void inject(LegislatorsActivity activity);
}
