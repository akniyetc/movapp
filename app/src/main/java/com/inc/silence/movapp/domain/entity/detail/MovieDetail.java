package com.inc.silence.movapp.domain.entity.detail;

import com.google.gson.annotations.SerializedName;
import io.realm.RealmList;
import io.realm.RealmObject;

public class MovieDetail extends RealmObject {
    public static final String BACKDROP_PATH = "backdrop_path";
    public static final String CREATED_BY = "created_by";
    public static final String EPISODE_RUN_TIME = "episode_run_time";
    public static final String FIRST_AIR_DATE = "first_air_date";
    public static final String GENRES = "genres";
    public static final String HOMEPAGE = "homepage";
    public static final String ID = "id";
    public static final String IN_PRODUCTION = "in_production";
    public static final String LANGUAGES = "languages";
    public static final String LAST_AIR_DATE = "last_air_date";
    public static final String NAME = "name";
    public static final String NETWORKS = "networks";
    public static final String NUMBER_OF_EPISODES = "number_of_episodes";
    public static final String NUMBER_OF_SEASONS = "number_of_seasons";
    public static final String ORIGIN_COUNTRY = "origin_country";
    public static final String ORIGINAL_LANGUAGE = "original_language";
    public static final String ORIGINAL_NAME = "original_name";
    public static final String OVERVIEW = "overview";
    public static final String POPULARITY = "popularity";
    public static final String POSTER_PATH = "poster_path";
    public static final String PRODUCTION_COMPANIES = "production_companies";
    public static final String SEASONS = "seasons";
    public static final String STATUS = "status";
    public static final String TYPE = "type";
    public static final String VOTE_AVERAGE = "vote_average";
    public static final String VOTE_COUNT = "vote_count";

    @SerializedName("backdrop_path")
    private String backdrop_path;
    @SerializedName("created_by")
    private RealmList<Created_by> created_by;
    @SerializedName("episode_run_time")
    private RealmList<Episode_run_time> episode_run_time;
    @SerializedName("first_air_date")
    private String first_air_date;
    @SerializedName("genres")
    private RealmList<Genres> genres;
    @SerializedName("homepage")
    private String homepage;
    @SerializedName("id")
    private int id;
    @SerializedName("in_production")
    private boolean in_production;
    @SerializedName("languages")
    private RealmList<Languages> languages;
    @SerializedName("last_air_date")
    private String last_air_date;
    @SerializedName("name")
    private String name;
    @SerializedName("networks")
    private RealmList<Networks> networks;
    @SerializedName("number_of_episodes")
    private int number_of_episodes;
    @SerializedName("number_of_seasons")
    private int number_of_seasons;
    @SerializedName("origin_country")
    private RealmList<Origin_country> origin_country;
    @SerializedName("original_language")
    private String original_language;
    @SerializedName("original_name")
    private String original_name;
    @SerializedName("overview")
    private String overview;
    @SerializedName("popularity")
    private float popularity;
    @SerializedName("poster_path")
    private String poster_path;
    @SerializedName("production_companies")
    private RealmList<Production_companies> production_companies;
    @SerializedName("seasons")
    private RealmList<Seasons> seasons;
    @SerializedName("status")
    private String status;
    @SerializedName("type")
    private String type;
    @SerializedName("vote_average")
    private float vote_average;
    @SerializedName("vote_count")
    private int vote_count;

    public MovieDetail(){ }

    public MovieDetail setBackdrop_path(String backdrop_path){
        this.backdrop_path = backdrop_path;
        return this;
    }
    public String getBackdrop_path(){
        return this.backdrop_path;
    }
    public MovieDetail setCreated_by(RealmList<Created_by> created_by){
        this.created_by = created_by;
        return this;
    }
    public RealmList<Created_by> getCreated_by(){
        return this.created_by;
    }
    public MovieDetail setEpisode_run_time(RealmList<Episode_run_time> episode_run_time){
        this.episode_run_time = episode_run_time;
        return this;
    }
    public RealmList<Episode_run_time> getEpisode_run_time(){
        return this.episode_run_time;
    }
    public MovieDetail setFirst_air_date(String first_air_date){
        this.first_air_date = first_air_date;
        return this;
    }
    public String getFirst_air_date(){
        return this.first_air_date;
    }
    public MovieDetail setGenres(RealmList<Genres> genres){
        this.genres = genres;
        return this;
    }
    public RealmList<Genres> getGenres(){
        return this.genres;
    }
    public MovieDetail setHomepage(String homepage){
        this.homepage = homepage;
        return this;
    }
    public String getHomepage(){
        return this.homepage;
    }
    public MovieDetail setId(int id){
        this.id = id;
        return this;
    }
    public int getId(){
        return this.id;
    }
    public MovieDetail setIn_production(boolean in_production){
        this.in_production = in_production;
        return this;
    }
    public boolean getIn_production(){
        return this.in_production;
    }
    public MovieDetail setLanguages(RealmList<Languages> languages){
        this.languages = languages;
        return this;
    }
    public RealmList<Languages> getLanguages(){
        return this.languages;
    }
    public MovieDetail setLast_air_date(String last_air_date){
        this.last_air_date = last_air_date;
        return this;
    }
    public String getLast_air_date(){
        return this.last_air_date;
    }
    public MovieDetail setName(String name){
        this.name = name;
        return this;
    }
    public String getName(){
        return this.name;
    }
    public MovieDetail setNetworks(RealmList<Networks> networks){
        this.networks = networks;
        return this;
    }
    public RealmList<Networks> getNetworks(){
        return this.networks;
    }
    public MovieDetail setNumber_of_episodes(int number_of_episodes){
        this.number_of_episodes = number_of_episodes;
        return this;
    }
    public int getNumber_of_episodes(){
        return this.number_of_episodes;
    }
    public MovieDetail setNumber_of_seasons(int number_of_seasons){
        this.number_of_seasons = number_of_seasons;
        return this;
    }
    public int getNumber_of_seasons(){
        return this.number_of_seasons;
    }
    public MovieDetail setOrigin_country(RealmList<Origin_country> origin_country){
        this.origin_country = origin_country;
        return this;
    }
    public RealmList<Origin_country> getOrigin_country(){
        return this.origin_country;
    }
    public MovieDetail setOriginal_language(String original_language){
        this.original_language = original_language;
        return this;
    }
    public String getOriginal_language(){
        return this.original_language;
    }
    public MovieDetail setOriginal_name(String original_name){
        this.original_name = original_name;
        return this;
    }
    public String getOriginal_name(){
        return this.original_name;
    }
    public MovieDetail setOverview(String overview){
        this.overview = overview;
        return this;
    }
    public String getOverview(){
        return this.overview;
    }
    public MovieDetail setPopularity(float popularity){
        this.popularity = popularity;
        return this;
    }
    public float getPopularity(){
        return this.popularity;
    }
    public MovieDetail setPoster_path(String poster_path){
        this.poster_path = poster_path;
        return this;
    }
    public String getPoster_path(){
        return this.poster_path;
    }
    public MovieDetail setProduction_companies(RealmList<Production_companies> production_companies){
        this.production_companies = production_companies;
        return this;
    }
    public RealmList<Production_companies> getProduction_companies(){
        return this.production_companies;
    }
    public MovieDetail setSeasons(RealmList<Seasons> seasons){
        this.seasons = seasons;
        return this;
    }
    public RealmList<Seasons> getSeasons(){
        return this.seasons;
    }
    public MovieDetail setStatus(String status){
        this.status = status;
        return this;
    }
    public String getStatus(){
        return this.status;
    }
    public MovieDetail setType(String type){
        this.type = type;
        return this;
    }
    public String getType(){
        return this.type;
    }
    public MovieDetail setVote_average(float vote_average){
        this.vote_average = vote_average;
        return this;
    }
    public float getVote_average(){
        return this.vote_average;
    }
    public MovieDetail setVote_count(int vote_count){
        this.vote_count = vote_count;
        return this;
    }
    public int getVote_count(){
        return this.vote_count;
    }
}

