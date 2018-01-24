package com.inc.silence.movapp.di.modules;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.f2prateek.rx.preferences2.RxSharedPreferences;
import com.inc.silence.movapp.data.settings.MoviesFilter;
import com.inc.silence.movapp.di.qualifier.ApplicationContext;
import com.inc.silence.movapp.di.qualifier.PrefFile;
import com.inc.silence.movapp.di.scopes.ApplicationScope;
import com.inc.silence.movapp.presentation.navigator.Navigator;
import com.inc.silence.movapp.utils.CommonUtils;
import com.inc.silence.movapp.utils.Constants;

import dagger.Module;
import dagger.Provides;

/**
 * Created by silence on 07.12.2017.
 */
@Module(includes = {RepositoryModule.class})
public class DataModule {

    @Provides
    @ApplicationScope
    SharedPreferences provideSharedPreferences(Application app) {
        return app.getSharedPreferences(Constants.KEY_PREFERENCES, Context.MODE_PRIVATE);
    }

    @Provides
    @ApplicationScope
    RxSharedPreferences provideRxSharedPreferences(SharedPreferences sharedPreferences) {
        return RxSharedPreferences.create(sharedPreferences);
    }

    @Provides
    @ApplicationScope
    MoviesFilter provideMoviesFilter(RxSharedPreferences rxSharedPreferences) {
        return new MoviesFilter(rxSharedPreferences);
    }

    @Provides
    @ApplicationScope
    CommonUtils provideCommonUtils(Application application) {
        return new CommonUtils(application);
    }

    @Provides
    @ApplicationScope
    Navigator provideNavigator() {
        return new Navigator();
    }
}
