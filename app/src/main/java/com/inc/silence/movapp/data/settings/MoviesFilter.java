package com.inc.silence.movapp.data.settings;

import com.f2prateek.rx.preferences2.Preference;
import com.f2prateek.rx.preferences2.RxSharedPreferences;
import com.inc.silence.movapp.utils.Constants;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by silence on 14.12.2017.
 */

public class MoviesFilter {

    public static final String API_KEY = "api_key";
    public static final String LANGUAGE = "language";
    public static final String PAGE = "page";

    private Preference<Integer> page;

    private boolean cached;
    private boolean loadMore;

    public MoviesFilter(RxSharedPreferences preferences) {
        page = preferences.getInteger(PAGE, 1);
    }

    public int getPage() {
        return page.get();
    }

    public void setPage(int page) {
        this.page.set(page);
    }

    public boolean isCached() {
        return cached;
    }

    public void setCached(boolean cached) {
        this.cached = cached;
    }

    public boolean isLoadMore() {
        return loadMore;
    }

    public void setLoadMore(boolean loadMore) {
        this.loadMore = loadMore;
    }

    public Map<String, String> getQueriesMovies() {
        Map<String, String> queries = new HashMap<>();
        queries.put(API_KEY, Constants.API_KEY);
        queries.put(LANGUAGE, Constants.LANGUAGE);
        queries.put(PAGE, page.get().toString());
        return queries;
    }

    public Map<String, String> getQueriesMovieDetail() {
        Map<String, String> queries = new HashMap<>();
        queries.put(API_KEY, Constants.API_KEY);
        queries.put(LANGUAGE, Constants.LANGUAGE);
        return queries;
    }
}
