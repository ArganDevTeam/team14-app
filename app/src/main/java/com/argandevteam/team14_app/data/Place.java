package com.argandevteam.team14_app.data;

/**
 * Created by markc on 20/01/2018.
 */

public class Place {
    String name;
    String imageUrl;
    long lat;
    long lon;

    public Place(String name, String imageUrl, long lat, long lon) {
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

    public long getLat() {
        return lat;
    }

    public long getLon() {
        return lon;
    }
}
