package com.argandevteam.team14_app.data.source.remote;

import com.argandevteam.team14_app.data.Detail;
import com.argandevteam.team14_app.data.User;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by markc on 20/01/2018.
 */

public interface APIService {
    @FormUrlEncoded
    @POST("user")
    Call<User> postUser(@Field("user_name") String userName);

    @GET("5a64786c2b00003107f41474")
    Call<Detail> getDetail();


    //search/madrid/1

}
