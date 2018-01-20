package com.argandevteam.team14_app.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by pablorojas on 20/1/18.
 */

public class Hotel {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("stars")
    @Expose
    private int stars;

    public Hotel() {
    }


    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getPrice() {
        return price;
    }

    public int getStars() {
        return stars;
    }

}
