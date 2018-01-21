package com.argandevteam.team14_app.detail;

import com.argandevteam.team14_app.data.Detail;
import com.argandevteam.team14_app.data.MyMapMarkers;
import com.argandevteam.team14_app.data.source.UsersDataSource;
import com.argandevteam.team14_app.data.source.UsersRepository;

import java.util.Arrays;

/**
 * Created by pablorojas on 20/1/18.
 */

public class DetailPresenter implements DetailContract.Presenter {


    private final String city;
    private DetailContract.View view;
    UsersRepository usersRepository;

    public DetailPresenter(String city, UsersRepository usersRepository, DetailContract.View view) {
        this.city = city;
        this.view = view;
        this.usersRepository = usersRepository;
        view.setPresenter(this);
    }

    @Override
    public void start() {
        usersRepository.getDetail(city, new UsersDataSource.LoadDetailCallback() {
            @Override
            public void onDetailCallback(Detail detail) {
                view.setDetail(detail);
            }

            @Override
            public void onError() {

            }
        });
    }

    @Override
    public void stop() {
        view = null;
    }
}
