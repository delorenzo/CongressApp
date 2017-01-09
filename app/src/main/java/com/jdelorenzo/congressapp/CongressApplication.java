package com.jdelorenzo.congressapp;

import android.app.Application;

import com.jdelorenzo.congressapp.network.DaggerNetComponent;
import com.jdelorenzo.congressapp.network.NetComponent;
import com.jdelorenzo.congressapp.network.NetModule;

public class CongressApplication extends Application {
    private NetComponent mNetComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mNetComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule(getString(R.string.base_api_url)))
                .build();
    }

    public NetComponent getNetComponent() {
        return mNetComponent;
    }
}
