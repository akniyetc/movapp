package com.inc.silence.movapp.ui.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.inc.silence.movapp.R;
import com.inc.silence.movapp.domain.entity.movies.Movie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by silence on 01.01.2018.
 */

public class MoviesListAdapter extends RecyclerView.Adapter<MoviesListViewHolder> {

    private MoviesActivity.OnItemSelectedListener mOnItemSelectedListener;
    private List<Movie> mMovieList;
    private Context mContext;

    public MoviesListAdapter(MoviesActivity.OnItemSelectedListener onItemSelectedListener,  Context context) {
        mOnItemSelectedListener = onItemSelectedListener;
        mMovieList = new ArrayList<>();
        mContext = context;
    }

    @Override
    public MoviesListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.item_movies_list, parent, false);
        return new MoviesListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MoviesListViewHolder holder, int position) {
        holder.bind(mMovieList.get(position), mOnItemSelectedListener);
    }

    @Override
    public int getItemCount() {
        if (mMovieList == null) {
            return 0;
        }
        return mMovieList.size();
    }

    public void setMovieList(List<Movie> movieList) {
        mMovieList = movieList;
    }
}
