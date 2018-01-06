package com.inc.silence.movapp.ui.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;

import com.inc.silence.movapp.R;
import com.inc.silence.movapp.app.App;
import com.inc.silence.movapp.ui.base.BaseActivity;
import com.inc.silence.movapp.ui.detail.MovieDetailActivity;
import com.inc.silence.movapp.ui.detail.MovieDetailFragment;
import com.inc.silence.movapp.ui.main.popular.PopularMoviesFragment;
import com.inc.silence.movapp.ui.main.topRated.TopRatedMoviesFragment;
import com.inc.silence.movapp.utils.CommonUtils;

import javax.inject.Inject;

import butterknife.BindView;

public class MoviesActivity extends BaseActivity {

    public static final String MOVIE_ID = "movie_id";

    @Inject
    CommonUtils mCommonUtils;

    @BindView(R.id.bottom_navigation)
    BottomNavigationView mBottomNavigationView;

    private String movieID;

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, MoviesActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getAppComponent().inject(this);
        setCustomContentView(mCommonUtils.isLarge() ? R.layout.activity_base_tablet : R.layout.activity_base);
        initToolbar(mToolbar);
        setTitle(getString(R.string.app_name));

        if (!mCommonUtils.isLarge() && savedInstanceState != null) {
            Fragment detailsFragment = getMovieDetailFragment();
            if (detailsFragment != null) {
                removeFragment(getMovieDetailFragment());
            }
        }
        chooseFragmentFromBottomNavigation();

        showPopular();
        if (savedInstanceState != null && savedInstanceState.get(MOVIE_ID) != null) {
            movieID = savedInstanceState.getString(MOVIE_ID);
        }
        if (mCommonUtils.isLarge()) {
            changeDetailsFragment();
        }
    }

    private void showPopular() {
        PopularMoviesFragment popularMoviesFragment = getPopularMoviesFragment();
        popularMoviesFragment.setOnItemSelectedListener(id -> {
            movieID = id;
            if (mCommonUtils.isLarge()) {
                changeDetailsFragment();
            } else {
                MovieDetailActivity.startActivity(MoviesActivity.this, id);
            }
        });
        changeFragment(popularMoviesFragment, R.id.container);
    }

    private void showTopRated() {
        TopRatedMoviesFragment topRatedMoviesFragment = getTopRatedMoviesFragment();
        topRatedMoviesFragment.setOnItemSelectedListener(id -> {
            movieID = id;
            if (mCommonUtils.isLarge()) {
                changeDetailsFragment();
            } else {
                MovieDetailActivity.startActivity(MoviesActivity.this, id);
            }
        });
        changeFragment(topRatedMoviesFragment, R.id.container);
    }

    private void chooseFragmentFromBottomNavigation() {
        mBottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.action_popular:
                    showPopular();
                    return true;
                case R.id.action_top_rated:
                    showTopRated();
                    return true;
            }
            return true;
        });
    }

    private PopularMoviesFragment getPopularMoviesFragment() {
        PopularMoviesFragment popularMoviesFragment = (PopularMoviesFragment) getCurrentFragment(R.id.container);
        if (popularMoviesFragment == null) {
            popularMoviesFragment = PopularMoviesFragment.newInstance();
        }
        return popularMoviesFragment;
    }

    private TopRatedMoviesFragment getTopRatedMoviesFragment() {
        TopRatedMoviesFragment topRatedMoviesFragment = (TopRatedMoviesFragment) getCurrentFragment(R.id.container);
        if (topRatedMoviesFragment == null) {
            topRatedMoviesFragment = TopRatedMoviesFragment.newInstance();
        }
        return topRatedMoviesFragment;
    }

    private MovieDetailFragment getMovieDetailFragment() {
        return (MovieDetailFragment) getCurrentFragment(R.id.details_container);
    }

    private void changeDetailsFragment() {
        MovieDetailFragment movieDetailFragment = getMovieDetailFragment();
        if (movieDetailFragment == null) {
            movieDetailFragment = (MovieDetailFragment) MovieDetailFragment.newInstance(movieID);
            changeFragment(movieDetailFragment, R.id.details_container);
        } else {
            movieDetailFragment.loadData(movieID);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(MOVIE_ID, movieID);
    }

    public interface OnItemSelectedListener {
        void onItemSelected(String id);
    }
}
