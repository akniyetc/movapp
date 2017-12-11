package com.inc.silence.movapp.domain.entity.movies;

import com.google.gson.annotations.SerializedName;
import io.realm.RealmObject;

public class Genre_ids extends RealmObject {
    public static final String VALUE = "value";

    @SerializedName("")
    private int value;

    public Genre_ids(){ }

    public Genre_ids setValue(int value){
        this.value = value;
        return this;
    }
    public int getValue(){
        return this.value;
    }
}

