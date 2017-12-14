package com.inc.silence.movapp.domain.entity.detail;

import com.google.gson.annotations.SerializedName;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Production_companies extends RealmObject {
    public static final String NAME = "name";
    public static final String ID = "id";

    @SerializedName(NAME)
    private String name;

    @PrimaryKey
    @SerializedName(ID)
    private int id;

    public Production_companies(){ }

    public Production_companies setName(String name){
        this.name = name;
        return this;
    }
    public String getName(){
        return this.name;
    }
    public Production_companies setId(int id){
        this.id = id;
        return this;
    }
    public int getId(){
        return this.id;
    }
}

