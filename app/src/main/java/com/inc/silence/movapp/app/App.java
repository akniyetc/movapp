package com.inc.silence.movapp.app;

import android.app.Application;
import android.os.Build;

import com.inc.silence.movapp.BuildConfig;
import com.inc.silence.movapp.di.components.AppComponent;
import com.inc.silence.movapp.di.components.DaggerAppComponent;
import com.inc.silence.movapp.di.modules.AppModule;

import io.realm.Realm;
import timber.log.Timber;

/**
 * Created by silence on 07.12.2017.
 */

public class App extends Application {

    private static AppComponent sAppComponent;

    public static AppComponent getAppComponent() {
        return sAppComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        sAppComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .build();
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }

        Realm.init(this);
    }
}
