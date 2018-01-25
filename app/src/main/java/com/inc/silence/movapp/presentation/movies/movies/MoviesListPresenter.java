package com.inc.silence.movapp.presentation.movies.movies;

import com.inc.silence.movapp.presentation.base.BasePresenter;

/**
 * Created by silence on 30.12.2017.
 */

public abstract class MoviesListPresenter extends BasePresenter<MoviesListView> {

    public abstract void getMovies(boolean cached);

    public abstract void loadMore();
    
    public abstract void setType(final String type);
    
}
