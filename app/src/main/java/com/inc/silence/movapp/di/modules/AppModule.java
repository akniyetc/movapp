package com.inc.silence.movapp.di.modules;

import android.app.Application;
import android.content.Context;

import com.inc.silence.movapp.di.qualifier.ApplicationContext;
import com.inc.silence.movapp.di.scopes.ActivityScope;
import com.inc.silence.movapp.di.scopes.ApplicationScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by silence on 07.12.2017.
 */
@Module(includes = {NetworkModule.class, DataModule.class, ActivityModule.class})
public class AppModule {

    private Application mApplication;

    public AppModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationScope
    Application provideApplication() {
        return mApplication;
    }

}
