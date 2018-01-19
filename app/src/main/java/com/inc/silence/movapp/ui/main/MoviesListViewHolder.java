package com.inc.silence.movapp.ui.main;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.inc.silence.movapp.R;
import com.inc.silence.movapp.app.App;
import com.inc.silence.movapp.domain.entity.movies.Movie;
import com.inc.silence.movapp.ui.base.BaseViewHolder;
import com.inc.silence.movapp.utils.Constants;

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

    public void bind(Movie movie, Context context, MoviesActivity.OnItemSelectedListener onItemSelectedListener) {
        Glide.with(context).load(Constants.ImgUrl + movie.getPoster_path()).into(movieImageView);
        itemView.setOnClickListener(view -> onItemSelectedListener.onItemSelected(movie.getId()));
    }
}
