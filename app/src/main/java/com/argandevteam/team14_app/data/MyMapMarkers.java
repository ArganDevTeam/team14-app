package com.argandevteam.team14_app.data;

import java.util.List;

/**
 * Created by pablorojas on 21/1/18.
 */

public class MyMapMarkers {

    private static final MyMapMarkers ourInstance = new MyMapMarkers();

    public static MyMapMarkers getInstance() {
        return ourInstance;
    }

    private List<Hotel> hotelList;
    private List<Poi> poiList;


    private MyMapMarkers() {
    }


    public List<Hotel> getHotelList() {
        return hotelList;
    }

    public void setHotelList(List<Hotel> hotelList) {
        this.hotelList = hotelList;
    }

    public List<Poi> getPoiList() {
        return poiList;
    }

    public void setPoiList(List<Poi> poiList) {
        this.poiList = poiList;
    }
}
