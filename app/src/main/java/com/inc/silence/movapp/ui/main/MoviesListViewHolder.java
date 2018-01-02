package com.inc.silence.movapp.ui.main;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.inc.silence.movapp.R;
import com.inc.silence.movapp.app.App;
import com.inc.silence.movapp.domain.entity.movies.Movie;
import com.inc.silence.movapp.ui.base.BaseViewHolder;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by silence on 01.01.2018.
 */

public class MoviesListViewHolder extends BaseViewHolder {

    @BindView(R.id.iv_movie)
    ImageView movieImageView;

    public MoviesListViewHolder(View itemView) {
        super(itemView);
        App.getAppComponent().inject(this);
    }

    public void bind(Movie movie, MoviesActivity.OnItemSelectedListener onItemSelectedListener) {
        Glide.with(itemView.getContext()).load(movie.getPoster_path()).into(movieImageView);
        movieImageView.setOnClickListener(view -> onItemSelectedListener.onItemSelected(movie.getId()));
    }
}
