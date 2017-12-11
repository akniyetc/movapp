package com.inc.silence.movapp.domain.entity.detail;

import com.google.gson.annotations.SerializedName;
import io.realm.RealmObject;

public class Episode_run_time extends RealmObject {
    public static final String VALUE = "value";

    @SerializedName("")
    private int value;

    public Episode_run_time(){ }

    public Episode_run_time setValue(int value){
        this.value = value;
        return this;
    }
    public int getValue(){
        return this.value;
    }
}

