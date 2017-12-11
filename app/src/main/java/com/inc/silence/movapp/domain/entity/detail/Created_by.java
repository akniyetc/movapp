package com.inc.silence.movapp.domain.entity.detail;

import com.google.gson.annotations.SerializedName;
import io.realm.RealmObject;

public class Created_by extends RealmObject {
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String PROFILE_PATH = "profile_path";

    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("profile_path")
    private String profile_path;

    public Created_by(){ }

    public Created_by setId(int id){
        this.id = id;
        return this;
    }
    public int getId(){
        return this.id;
    }
    public Created_by setName(String name){
        this.name = name;
        return this;
    }
    public String getName(){
        return this.name;
    }
    public Created_by setProfile_path(String profile_path){
        this.profile_path = profile_path;
        return this;
    }
    public String getProfile_path(){
        return this.profile_path;
    }
}

