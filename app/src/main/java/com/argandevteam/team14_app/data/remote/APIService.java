package com.argandevteam.team14_app.data.remote;

import com.argandevteam.team14_app.data.User;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by markc on 20/01/2018.
 */

public interface APIService {
    @GET("5a634f3a2e00003a0911d885")
    Call<User> getUser();
}
