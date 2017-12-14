package com.inc.silence.movapp.data.settings;

import com.f2prateek.rx.preferences2.Preference;
import com.f2prateek.rx.preferences2.RxSharedPreferences;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by silence on 14.12.2017.
 */

public class MoviesFilter {

    public static final String API_KEY = "api_key";
    public static final String LANGUAGE = "language";
    public static final String PAGE = "page";

    private Preference<String> apiKey;
    private Preference<String> language;
    private Preference<Integer> page;

    private boolean cached;
    private boolean loadMore;

    public MoviesFilter(RxSharedPreferences preferences) {
        apiKey = preferences.getString(API_KEY, "");
        language = preferences.getString(LANGUAGE, "");
        page = preferences.getInteger(PAGE, 0);
    }

    public String getApiKey() {
        return apiKey.get();
    }

    public void setApiKey(String apiKey) {
        this.apiKey.set(apiKey);
    }

    public String getLanguage() {
        return language.get();
    }

    public void setLanguage(String language) {
        this.language.set(language);
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

    public Map<String, String> getQueries() {
        Map<String, String> queries = new HashMap<>();
        if (apiKey.isSet() && !apiKey.get().isEmpty()) {
            queries.put("api_key", apiKey.get());
        }
        if (language.isSet() && !language.get().isEmpty()) {
            queries.put("language", language.get());
        }
        queries.put("page", page.get().toString());
        return queries;
    }
}
