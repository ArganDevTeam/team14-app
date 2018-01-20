package com.argandevteam.team14_app.data.source.remote;

import android.util.Log;

import com.argandevteam.team14_app.data.Place;
import com.argandevteam.team14_app.data.User;
import com.argandevteam.team14_app.data.source.UsersDataSource;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by markc on 20/01/2018.
 */

public class UsersRemoteDataSource implements UsersDataSource {

    private static UsersRemoteDataSource INSTANCE;

    APIService apiService;
    private static final String TAG = "UsersRemoteDS";

    private UsersRemoteDataSource() {
        Retrofit retrofit = APIClient.getClient();

        apiService = retrofit.create(APIService.class);

    }

    public static UsersRemoteDataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new UsersRemoteDataSource();
        }
        return INSTANCE;
    }

    @Override
    public void getUser(final LoadUserCallback callback) {
        Call<User> call = apiService.getUser();

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user = response.body();


                callback.onUserCallback(user);
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e(TAG, "onFailure: ERROR WHILE REQUESTING", t);
            }
        });

    }

    @Override
    public void getPlaces(final LoadPlacesCallback callback) {
        Call<User> call = apiService.getUser();

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user = response.body();

                List<Place> places = user.getPlaces();

                callback.onPlacesCallback(places);
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e(TAG, "onFailure: ERROR WHILE REQUESTING", t);
            }
        });
    }
}
