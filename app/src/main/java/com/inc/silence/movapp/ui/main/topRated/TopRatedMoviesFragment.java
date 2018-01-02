package com.inc.silence.movapp.ui.main.topRated;

import android.os.Bundle;

import com.inc.silence.movapp.di.components.AppComponent;
import com.inc.silence.movapp.ui.base.BaseFragment;

/**
 * Created by silence on 01.01.2018.
 */

public class TopRatedMoviesFragment extends BaseFragment {
    @Override
    public void setupComponent(AppComponent appComponent) {

    }

    public static TopRatedMoviesFragment newInstance() {
        return new TopRatedMoviesFragment();
    }
}
