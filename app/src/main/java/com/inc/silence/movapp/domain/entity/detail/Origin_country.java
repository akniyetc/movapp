package com.inc.silence.movapp.domain.entity.detail;

import com.google.gson.annotations.SerializedName;
import io.realm.RealmObject;

public class Origin_country extends RealmObject {
    public static final String VALUE = "value";

    @SerializedName("")
    private String value;

    public Origin_country(){ }

    public Origin_country setValue(String value){
        this.value = value;
        return this;
    }
    public String getValue(){
        return this.value;
    }
}

