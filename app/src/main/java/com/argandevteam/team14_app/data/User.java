package com.argandevteam.team14_app.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by markc on 20/01/2018.
 */

public class User {
    String name;
    String type;
    @SerializedName("cities")
    List<Place> places;
    @SerializedName("sensitivity")
    int sensitivity;

    public User(String name, String type, List<Place> places, int sensitivity) {
        this.name = name;
        this.type = type;
        this.places = places;
        this.sensitivity = sensitivity;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public int getSensitivity() {
        return sensitivity;
    }
}
