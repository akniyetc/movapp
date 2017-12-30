package com.inc.silence.movapp.domain.entity.main;

import com.google.gson.annotations.SerializedName;
import com.inc.silence.movapp.domain.entity.movies.Movie;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Movies extends RealmObject {
    public static final String PAGE = "page";
    public static final String ID = "id";
    public static final String TOTAL_RESULTS = "total_results";
    public static final String TOTAL_PAGES = "total_pages";
    public static final String RESULTS = "results";

    @PrimaryKey
    @SerializedName(ID)
    private String id;

    @SerializedName(PAGE)
    private int page;
    @SerializedName(TOTAL_RESULTS)
    private int total_results;
    @SerializedName(TOTAL_PAGES)
    private int total_pages;
    @SerializedName(RESULTS)
    private RealmList<Movie> results;

    public Movies(){ }

    public String getId() {
        return id;
    }

    public Movies setId(String id) {
        this.id = id;
        return this;
    }

    public Movies setPage(int page){
        this.page = page;
        return this;
    }
    public int getPage(){
        return this.page;
    }
    public Movies setTotal_results(int total_results){
        this.total_results = total_results;
        return this;
    }
    public int getTotal_results(){
        return this.total_results;
    }
    public Movies setTotal_pages(int total_pages){
        this.total_pages = total_pages;
        return this;
    }
    public int getTotal_pages(){
        return this.total_pages;
    }
    public Movies setResults(RealmList<Movie> results){
        this.results = results;
        return this;
    }
    public RealmList<Movie> getResults(){
        return this.results;
    }
}

