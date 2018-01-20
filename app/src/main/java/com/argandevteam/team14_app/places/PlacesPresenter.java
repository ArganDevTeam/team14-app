package com.argandevteam.team14_app.places;

import com.argandevteam.team14_app.data.Place;
import com.argandevteam.team14_app.data.User;
import com.argandevteam.team14_app.data.source.UsersDataSource;
import com.argandevteam.team14_app.data.source.UsersRepository;

import java.util.List;

/**
 * Created by markc on 20/01/2018.
 */

public class PlacesPresenter implements PlacesContract.Presenter {

    private final UsersRepository usersRepository;
    PlacesContract.View view;

    public PlacesPresenter(UsersRepository usersRepository, PlacesContract.View view) {
        this.usersRepository = usersRepository;
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void start() {
        loadPlaces();
    }

    private void loadPlaces() {
        usersRepository.getPlaces(new UsersDataSource.LoadPlacesCallback() {
            @Override
            public void onPlacesCallback(List<Place> places) {
                view.showPlaces(places);
            }

            @Override
            public void onError() {
                view.showLoadPlacesError();
            }
        });
    }

    @Override
    public void stop() {
        view = null;
    }
}
