package com.argandevteam.team14_app.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by markc on 20/01/2018.
 */

public class Place {
    String name;
    String img;
    float lat;
    @SerializedName("long")
    float lon;

    public Place(String name, String img, float lat, float lon) {
        this.name = name;
        this.img = img;
        this.lat = lat;
        this.lon = lon;
    }

    public String getName() {
        return name;
    }

    public String getImg() {
        return img;
    }

    public float getLat() {
        return lat;
    }

    public float getLon() {
        return lon;
    }
}
