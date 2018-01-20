package com.argandevteam.team14_app.places;

/**
 * Created by markc on 20/01/2018.
 */

public class PlacesPresenter implements PlacesContract.Presenter {

    PlacesContract.View view;

    public PlacesPresenter(PlacesContract.View view) {
        this.view = view;
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {
        view = null;
    }
}
