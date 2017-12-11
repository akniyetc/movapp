package com.inc.silence.movapp.domain.entity.detail;

import com.google.gson.annotations.SerializedName;
import io.realm.RealmObject;

public class Genres extends RealmObject {
    public static final String ID = "id";
    public static final String NAME = "name";

    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;

    public Genres(){ }

    public Genres setId(int id){
        this.id = id;
        return this;
    }
    public int getId(){
        return this.id;
    }
    public Genres setName(String name){
        this.name = name;
        return this;
    }
    public String getName(){
        return this.name;
    }
}

