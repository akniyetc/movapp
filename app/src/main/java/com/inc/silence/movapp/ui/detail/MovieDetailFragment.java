package com.inc.silence.movapp.ui.detail;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.inc.silence.movapp.R;
import com.inc.silence.movapp.app.App;
import com.inc.silence.movapp.di.components.AppComponent;
import com.inc.silence.movapp.domain.entity.main.MovieDetail;
import com.inc.silence.movapp.domain.entity.movies.Movie;
import com.inc.silence.movapp.presentation.movies.detail.DetailMoviePresenter;
import com.inc.silence.movapp.presentation.movies.detail.DetailMovieView;
import com.inc.silence.movapp.ui.base.BaseFragment;
import com.inc.silence.movapp.utils.Constants;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by silence on 01.01.2018.
 */

public class MovieDetailFragment extends BaseFragment implements DetailMovieView {

    @BindView(R.id.container)
    View mContainer;

    @BindView(R.id.progressBar)
    ProgressBar mProgressBar;

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

    private MovieDetail mMovie;
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
        mView = inflater.inflate(R.layout.fragment_detail, container, false);
        return mView;
    }

    public void loadData(String id) {
        mMovieID = id;
        mDetailMoviePresenter.getMovieDetail(mMovieID);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mDetailMoviePresenter.attachView(this);
        mDetailMoviePresenter.getMovieDetail(mMovieID);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mDetailMoviePresenter.detachView();
    }

    @Override
    public void showLoadingProgress() {
        mContainer.setVisibility(View.GONE);
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoadingProgress() {
        mContainer.setVisibility(View.VISIBLE);
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void showErrorMessage(String error) {
        Snackbar.make(mView, error, Snackbar.LENGTH_INDEFINITE)
                .setAction(R.string.try_again_snack_bar, v -> mDetailMoviePresenter.getMovieDetail(mMovieID))
                .show();
    }

    @Override
    public void getDetailMovieDone(MovieDetail movieDetail) {
        mMovie = movieDetail;
        fillView();
    }

    private void fillView() {
        if (mMovie == null) {
            return;
        }

        Glide.with(getContext())
                .load(Constants.ImgUrl + mMovie.getPoster_path())
                .into(mMoviePoster);
        mMovieName.setText(mMovie.getName());
        mMovieRating.setText(String.valueOf(mMovie.getVote_count()));
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            mMovieDescription.setText(Html.fromHtml(mMovie.getOverview(), Html.FROM_HTML_MODE_LEGACY));
        } else {
            mMovieDescription.setText(Html.fromHtml(mMovie.getOverview()));
        }
    }
}
