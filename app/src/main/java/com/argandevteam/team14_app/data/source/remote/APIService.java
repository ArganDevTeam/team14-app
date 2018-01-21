package com.argandevteam.team14_app.data.source.remote;

import com.argandevteam.team14_app.data.Detail;
import com.argandevteam.team14_app.data.User;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by markc on 20/01/2018.
 */

public interface APIService {
    @GET("5a6460c22b0000fc04f41452")
    Call<User> getUser();

    @GET("5a63520d2e0000420911d887")
    Call<Detail> getDetail();
}
