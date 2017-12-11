package com.inc.silence.movapp.domain.entity.movies;

import com.google.gson.annotations.SerializedName;
import io.realm.RealmList;
import io.realm.RealmObject;

public class Movies extends RealmObject {
    public static final String PAGE = "page";
    public static final String TOTAL_RESULTS = "total_results";
    public static final String TOTAL_PAGES = "total_pages";
    public static final String RESULTS = "results";

    @SerializedName("page")
    private int page;
    @SerializedName("total_results")
    private int total_results;
    @SerializedName("total_pages")
    private int total_pages;
    @SerializedName("results")
    private RealmList<Results> results;

    public Movies(){ }

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
    public Movies setResults(RealmList<Results> results){
        this.results = results;
        return this;
    }
    public RealmList<Results> getResults(){
        return this.results;
    }
}

