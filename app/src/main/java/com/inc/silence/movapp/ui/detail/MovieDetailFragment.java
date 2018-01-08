package com.inc.silence.movapp.ui.detail;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.inc.silence.movapp.R;
import com.inc.silence.movapp.app.App;
import com.inc.silence.movapp.di.components.AppComponent;
import com.inc.silence.movapp.domain.entity.main.MovieDetail;
import com.inc.silence.movapp.domain.entity.movies.Movie;
import com.inc.silence.movapp.presentation.movies.detail.DetailMoviePresenter;
import com.inc.silence.movapp.presentation.movies.detail.DetailMovieView;
import com.inc.silence.movapp.ui.base.BaseFragment;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by silence on 01.01.2018.
 */

public class MovieDetailFragment extends BaseFragment implements DetailMovieView {

    @BindView(R.id.swipeRefreshDetail)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @BindView(R.id.show_image)
    ImageView mMoviePoster;

    @BindView(R.id.show_name)
    TextView mMovieName;

    @BindView(R.id.rating)
    TextView mMovieRating;

    @BindView(R.id.description)
    TextView mMovieDescription;

    @Inject
    DetailMoviePresenter mDetailMoviePresenter;

    private Movie mMovie;
    private View mView;
    private String mMovieID;

    @Override
    public void setupComponent(AppComponent appComponent) {
        App.getAppComponent().inject(this);
    }

    public static MovieDetailFragment newInstance(String id) {

        Bundle args = new Bundle();
        args.putString(MovieDetailActivity.EXTRA_ID, id);
        MovieDetailFragment fragment = new MovieDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMovieID = getArguments().getString(MovieDetailActivity.EXTRA_ID);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        return view;
    }

    public void loadData(String id) {
        mMovieID = id;
        mDetailMoviePresenter.getMovieDetail(mMovieID);
    }

    @Override
    public void showLoadingProgress() {

    }

    @Override
    public void hideLoadingProgress() {

    }

    @Override
    public void showErrorMessage(String error) {

    }

    @Override
    public void getDetailMovieDone(MovieDetail movieDetail) {

    }
}
