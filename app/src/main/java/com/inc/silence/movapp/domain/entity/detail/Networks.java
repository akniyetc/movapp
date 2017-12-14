package com.inc.silence.movapp.domain.entity.detail;

import com.google.gson.annotations.SerializedName;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Networks extends RealmObject {
    public static final String ID = "id";
    public static final String NAME = "name";

    @PrimaryKey
    @SerializedName(ID)
    private int id;
    @SerializedName(NAME)
    private String name;

    public Networks(){ }

    public Networks setId(int id){
        this.id = id;
        return this;
    }
    public int getId(){
        return this.id;
    }
    public Networks setName(String name){
        this.name = name;
        return this;
    }
    public String getName(){
        return this.name;
    }
}

