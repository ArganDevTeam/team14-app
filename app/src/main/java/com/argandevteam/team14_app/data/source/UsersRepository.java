package com.argandevteam.team14_app.data.source;

import com.argandevteam.team14_app.data.Detail;
import com.argandevteam.team14_app.data.Place;
import com.argandevteam.team14_app.data.User;

import java.util.Arrays;

import com.argandevteam.team14_app.data.Place;

import java.util.List;


/**
 * Created by markc on 20/01/2018.
 */

public class UsersRepository implements UsersDataSource {

    private UsersDataSource remoteDataSource;
    private Object places;

    public UsersRepository(UsersDataSource remoteDataSource) {
        this.remoteDataSource = remoteDataSource;
    }

    @Override
    public void postUser(String userName, final LoadUserCallback callback) {
        remoteDataSource.postUser(userName, new LoadUserCallback() {
            @Override
            public void onUserCallback(User user) {
                callback.onUserCallback(user);
            }

            @Override
            public void onError() {
                callback.onError();
            }
        });
    }

    @Override
    public void getPlaces(String userName, final LoadPlacesCallback callback) {
        remoteDataSource.getPlaces(userName, new LoadPlacesCallback() {
            @Override
            public void onPlacesCallback(List<Place> places) {
                callback.onPlacesCallback(places);
            }

            @Override
            public void onError() {
                callback.onError();
            }
        });
    }

    @Override
    public void getDetail(final LoadDetailCallback callback) {
        remoteDataSource.getDetail(new LoadDetailCallback() {
            @Override
            public void onDetailCallback(Detail detail) {
                MyMapMarkers.getInstance().setHotelList(Arrays.asList(detail.getHotels()));
                MyMapMarkers.getInstance().setPoiList(Arrays.asList(detail.getPois()));
                callback.onDetailCallback(detail);
            }

            @Override
            public void onError() {
                callback.onError();
            }
        });
    }
}
