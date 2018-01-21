package com.argandevteam.team14_app.data.source.remote;

import com.argandevteam.team14_app.data.Detail;
import com.argandevteam.team14_app.data.User;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by markc on 20/01/2018.
 */

public interface APIService {
    @POST("user")
    Call<User> postUser(@Field("user_name") String userName);

    @GET("5a646b2b2b0000cf05f41460")
    Call<Detail> getDetail();


    //search/madrid/1

}
