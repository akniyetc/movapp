package com.inc.silence.movapp.presentation.movies.popular;

import com.inc.silence.movapp.presentation.base.BasePresenter;

/**
 * Created by silence on 30.12.2017.
 */

public abstract class MoviesListPresenter extends BasePresenter<MoviesListView> {

    public abstract void getPopularMovies (boolean cached);

    public abstract void getTopRatedMovies(boolean cached);

    public abstract void loadMore();
}
