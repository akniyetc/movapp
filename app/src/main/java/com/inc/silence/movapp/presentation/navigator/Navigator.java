package com.inc.silence.movapp.presentation.navigator;

import android.content.Context;
import android.content.Intent;

import com.inc.silence.movapp.ui.detail.MovieDetailActivity;
import com.inc.silence.movapp.ui.main.MoviesActivity;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by User on 24.01.2018.
 */
@Singleton
public class Navigator {

    @Inject
    public Navigator() {
        //empty
    }

    public void navigateToMoviesList(Context context) {
        if (context != null) {
            Intent launchIntent = MoviesActivity.getCallingIntent(context);
            context.startActivity(launchIntent);
        }
    }

    public void navigateToDetail(Context context, String movieId) {
        if (context != null) {
            Intent launchIntent = MovieDetailActivity.getCallingIntent(context, movieId);
            context.startActivity(launchIntent);
        }
    }
}
