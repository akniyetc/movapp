package com.inc.silence.movapp.presentation.movies.detail;

import com.inc.silence.movapp.presentation.base.BasePresenter;

/**
 * Created by silence on 02.01.2018.
 */

public abstract class DetailMoviePresenter extends BasePresenter<DetailMovieView> {

    public abstract void getMovieDetail(String id);
}
