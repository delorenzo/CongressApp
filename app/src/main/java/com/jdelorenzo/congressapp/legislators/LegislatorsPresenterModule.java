package com.jdelorenzo.congressapp.legislators;

import dagger.Module;
import dagger.Provides;

@Module
public class LegislatorsPresenterModule {

    private final LegislatorsContract.View mView;

    public LegislatorsPresenterModule(LegislatorsContract.View view) {
        mView = view;
    }

    @Provides
    LegislatorsContract.View provideMainContractView() {
        return mView;
    }
}
