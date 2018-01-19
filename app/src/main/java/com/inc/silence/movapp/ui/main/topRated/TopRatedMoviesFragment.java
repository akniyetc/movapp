package com.inc.silence.movapp.ui.main.topRated;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.inc.silence.movapp.R;
import com.inc.silence.movapp.app.App;
import com.inc.silence.movapp.data.settings.MoviesFilter;
import com.inc.silence.movapp.di.components.AppComponent;
import com.inc.silence.movapp.domain.entity.movies.Movie;
import com.inc.silence.movapp.presentation.movies.popular.PopularMoviesPresenter;
import com.inc.silence.movapp.presentation.movies.rated.TopRatedMoviesPresenter;
import com.inc.silence.movapp.presentation.movies.rated.TopRatedMoviesView;
import com.inc.silence.movapp.ui.base.BaseFragment;
import com.inc.silence.movapp.ui.main.MoviesActivity;
import com.inc.silence.movapp.ui.main.MoviesListAdapter;
import com.inc.silence.movapp.utils.RecyclerViewListener;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by silence on 01.01.2018.
 */

public class TopRatedMoviesFragment extends BaseFragment implements TopRatedMoviesView {

    private final String KEY_RECYCLER_STATE_TOP = "recycler_state_top";

    @BindView(R.id.mainLayout)
    View mMainLayout;

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout mRefreshLayout;

    @BindView(R.id.noDataError)
    TextView mNoDataError;

    @Inject
    MoviesFilter mMoviesFilter;

    @Inject
    TopRatedMoviesPresenter mTopRatedMoviesPresenter;

    private View mView;
    private RecyclerViewListener mRecyclerViewListener;
    private MoviesActivity.OnItemSelectedListener mOnItemSelectedListener;
    private MoviesListAdapter mAdapter;
    private Parcelable mRecyclerViewState;

    @Override
    public void setupComponent(AppComponent appComponent) {
        App.getAppComponent().inject(this);
    }

    public static TopRatedMoviesFragment newInstance() {
        return new TopRatedMoviesFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            mRecyclerViewState = savedInstanceState.getParcelable(KEY_RECYCLER_STATE_TOP);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_movies, container, false);
        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mTopRatedMoviesPresenter.attachView(this);
        mTopRatedMoviesPresenter.getTopRatedMovies(savedInstanceState != null);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mTopRatedMoviesPresenter.detachView();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(KEY_RECYCLER_STATE_TOP, mRecyclerView.getLayoutManager().onSaveInstanceState());
    }

    @Override
    public void getTopRatedMoviesDone(List<Movie> movies) {
        mAdapter.setMovieList(movies);
        restoreState();
    }

    private void refreshList() {
        mRecyclerViewListener.refresh();
        mTopRatedMoviesPresenter.getTopRatedMovies(false);
    }

    @Override
    public void setSubtitle(String text) {
        super.setSubtitle(text);
    }

    private void restoreState() {
        if (mRecyclerViewState != null) {
            mRecyclerView.getLayoutManager().onRestoreInstanceState(mRecyclerViewState);
            mRecyclerViewState = null;
        }
    }

    @Override
    public void showLoadingProgress() {
        mRefreshLayout.setRefreshing(true);
        mNoDataError.setVisibility(View.GONE);
    }

    @Override
    public void hideLoadingProgress() {
        mRefreshLayout.setRefreshing(false);
        mNoDataError.setVisibility(mAdapter.getItemCount() != 0 ? View.VISIBLE : View.GONE);
    }

    @Override
    public void showErrorMessage(String error) {
        Snackbar.make(mView, error, Snackbar.LENGTH_LONG).show();
    }

    private void initViews() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        mRecyclerViewListener = new RecyclerViewListener(gridLayoutManager);
        mRecyclerViewListener.setOnLoadMoreListener(() -> mTopRatedMoviesPresenter.loadMore());

        mAdapter = new MoviesListAdapter(mOnItemSelectedListener, getContext());
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addOnScrollListener(mRecyclerViewListener);
        mRefreshLayout.setColorSchemeResources(R.color.colorPrimary, R.color.colorAccent, R.color.colorPrimaryDark);
        mRefreshLayout.setOnRefreshListener(this::refreshList);
    }

    public void setOnItemSelectedListener(MoviesActivity.OnItemSelectedListener onItemSelectedListener) {
        mOnItemSelectedListener = onItemSelectedListener;
    }
}
