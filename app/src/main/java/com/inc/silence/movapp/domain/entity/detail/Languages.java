package com.inc.silence.movapp.domain.entity.detail;

import com.google.gson.annotations.SerializedName;
import io.realm.RealmObject;

public class Languages extends RealmObject {
    public static final String VALUE = "value";

    @SerializedName("")
    private String value;

    public Languages(){ }

    public Languages setValue(String value){
        this.value = value;
        return this;
    }
    public String getValue(){
        return this.value;
    }
}

