package com.argandevteam.team14_app.map;

/**
 * Created by markc on 20/01/2018.
 */

public class MapPresenter implements MapContract.Presenter {

    MapContract.View view;

    public MapPresenter(MapContract.View view) {
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {
        this.view = null;
    }
}
