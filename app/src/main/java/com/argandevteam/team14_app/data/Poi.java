package com.argandevteam.team14_app.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by pablorojas on 20/1/18.
 */

public class Poi {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("subcategory")
    @Expose
    private String subcatecory;
    @SerializedName("lat")
    @Expose
    private double latitude;
    @SerializedName("long")
    @Expose
    private double longitude;

    public Poi() {
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getSubcatecory() {
        return subcatecory;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
