package com.jdelorenzo.congressapp;

import android.app.Application;

import com.jdelorenzo.congressapp.network.DaggerNetComponent;
import com.jdelorenzo.congressapp.network.NetComponent;
import com.jdelorenzo.congressapp.network.NetModule;

public class CongressApplication extends Application {
    private NetComponent netComponent;
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        AppModule appModule = new AppModule(this);
        netComponent = DaggerNetComponent.builder()
                .appModule(appModule)
                .netModule(new NetModule(getString(R.string.base_api_url)))
                .build();
        appComponent = DaggerAppComponent.builder()
                .appModule(appModule)
                .build();
    }

    public NetComponent getNetComponent() {
        return netComponent;
    }

    public AppComponent getAppComponent() { return appComponent; }
}
