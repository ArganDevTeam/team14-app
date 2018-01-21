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
    @SerializedName("images")
    @Expose
    private String images;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("lat")
    @Expose
    private double latitude;
    @SerializedName("long")
    @Expose
    private double longitude;
    @SerializedName("stars")
    @Expose
    private int stars;
    @SerializedName("booking_url")
    @Expose
    private int bookingUrl;
    @SerializedName("description")
    @Expose
    private int description;


    public Hotel() {
    }


    public String getName() {
        return name;
    }

    public String getImages() {
        return images;
    }

    public String getPrice() {
        return price;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public int getStars() {
        return stars;
    }

    public int getBookingUrl() {
        return bookingUrl;
    }

    public int getDescription() {
        return description;
    }
}
