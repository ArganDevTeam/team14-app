package com.argandevteam.team14_app.data;

/**
 * Created by markc on 20/01/2018.
 */

public class Place {
    String name;
    String imageUrl;
    float lat;
    float lon;

    public Place(String name, String imageUrl, float lat, float lon) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.lat = lat;
        this.lon = lon;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public float getLat() {
        return lat;
    }

    public float getLon() {
        return lon;
    }
}
