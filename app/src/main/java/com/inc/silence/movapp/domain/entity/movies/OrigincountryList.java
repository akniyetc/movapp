package com.inc.silence.movapp.domain.entity.movies;

import com.google.gson.annotations.SerializedName;
import io.realm.RealmObject;

public class OrigincountryList extends RealmObject {
    public static final String VALUE = "value";

    @SerializedName("")
    private String value;

    public OrigincountryList(){ }

    public OrigincountryList setValue(String value){
        this.value = value;
        return this;
    }
    public String getValue(){
        return this.value;
    }
}

