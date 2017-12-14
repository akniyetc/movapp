package com.inc.silence.movapp.domain.entity.base;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by neox on 22.09.17.
 */

public class IdNameRealm extends RealmObject {

    public static final String ID = "id";
    public static final String NAME = "name";

    @PrimaryKey
    @SerializedName(ID)
    private String id;

    @SerializedName(NAME)
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
