package com.inc.silence.movapp.presentation.movies.rated;

import com.inc.silence.movapp.presentation.base.BasePresenter;

/**
 * Created by silence on 05.01.2018.
 */

public abstract class TopRatedMoviesPresenter extends BasePresenter<TopRatedMoviesView> {

    public abstract void getTopRatedMovies (boolean cached);

    public abstract void loadMore();
}
