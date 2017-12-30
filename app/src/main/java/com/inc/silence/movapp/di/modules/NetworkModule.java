package com.inc.silence.movapp.di.modules;

import android.app.Application;

import com.inc.silence.movapp.data.api.MainService;
import com.inc.silence.movapp.di.qualifier.Logger;
import com.inc.silence.movapp.di.qualifier.Url;
import com.inc.silence.movapp.di.scopes.ApplicationScope;
import com.inc.silence.movapp.utils.Constants;

import java.io.File;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by silence on 07.12.2017.
 */
@Module
public class NetworkModule {

    private static final int TIMEOUT = 60;

    @Provides
    @ApplicationScope
    MainService provideMainService(OkHttpClient okHttpClient, @Url String baseUrl) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(MainService.class);
    }

    @Provides
    @ApplicationScope
    OkHttpClient provideOkHttpClient(Application application, @Logger Interceptor interceptor) {
        File cacheFile = null;
        Cache cache = null;
        try {
            cacheFile = new File(application.getCacheDir(), "responses");
            cache = new Cache(cacheFile, 10 * 1024 * 1024);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new OkHttpClient.Builder()
                .connectTimeout(TIMEOUT, SECONDS)
                .readTimeout(TIMEOUT, SECONDS)
                .writeTimeout(TIMEOUT, SECONDS)
                .addInterceptor(interceptor)
                .cache(cache)
                .build();
    }

    @Provides
    @ApplicationScope
    @Logger
    Interceptor provideLoggerInterceptor() {
        return new HttpLoggingInterceptor(message -> Timber.d(message))
                .setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    @Url
    @Provides
    String retrofitUrl() {
        return Constants.BASE_URL;
    }
}
