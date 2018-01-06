package com.inc.silence.movapp.presentation.movies.popular;

import com.inc.silence.movapp.presentation.base.BasePresenter;

/**
 * Created by silence on 30.12.2017.
 */

public abstract class PopularMoviesPresenter extends BasePresenter<PopularMoviesView> {

    public abstract void getPopularMovies (boolean cached);

    public abstract void loadMore();
}
