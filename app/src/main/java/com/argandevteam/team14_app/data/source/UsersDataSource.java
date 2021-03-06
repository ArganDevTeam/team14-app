package com.argandevteam.team14_app.data.source;

import com.argandevteam.team14_app.data.Detail;
import com.argandevteam.team14_app.data.Place;
import com.argandevteam.team14_app.data.User;

import java.util.List;

/**
 * Created by markc on 20/01/2018.
 */

public interface UsersDataSource {

    void getUser(String userName, LoadUserCallback callback);

    void getPlaces(String userName, LoadPlacesCallback callback);

    void getDetail(String city, LoadDetailCallback callback);

    interface LoadUserCallback {
        void onUserCallback(User user);

        void onError();
    }

    interface LoadPlacesCallback {
        void onPlacesCallback(List<Place> places);

        void onError();
    }

    interface LoadDetailCallback {
        void onDetailCallback(Detail detail);
        void onError();
    }
}
