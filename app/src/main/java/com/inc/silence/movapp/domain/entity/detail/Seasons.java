package com.inc.silence.movapp.domain.entity.detail;

import com.google.gson.annotations.SerializedName;
import io.realm.RealmObject;

public class Seasons extends RealmObject {
    public static final String EPISODE_COUNT = "episode_count";
    public static final String ID = "id";
    public static final String POSTER_PATH = "poster_path";
    public static final String SEASON_NUMBER = "season_number";
    public static final String AIR_DATE = "air_date";

    @SerializedName("episode_count")
    private int episode_count;
    @SerializedName("id")
    private int id;
    @SerializedName("poster_path")
    private String poster_path;
    @SerializedName("season_number")
    private int season_number;
    @SerializedName("air_date")
    private String air_date;

    public Seasons(){ }

    public Seasons setEpisode_count(int episode_count){
        this.episode_count = episode_count;
        return this;
    }
    public int getEpisode_count(){
        return this.episode_count;
    }
    public Seasons setId(int id){
        this.id = id;
        return this;
    }
    public int getId(){
        return this.id;
    }
    public Seasons setPoster_path(String poster_path){
        this.poster_path = poster_path;
        return this;
    }
    public String getPoster_path(){
        return this.poster_path;
    }
    public Seasons setSeason_number(int season_number){
        this.season_number = season_number;
        return this;
    }
    public int getSeason_number(){
        return this.season_number;
    }
    public Seasons setAir_date(String air_date){
        this.air_date = air_date;
        return this;
    }
    public String getAir_date(){
        return this.air_date;
    }
}

