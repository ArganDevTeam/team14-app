package com.argandevteam.team14_app.prebooking;

/**
 * Created by markc on 20/01/2018.
 */

public class PreBookingPresenter implements PreBookingContract.Presenter {

    PreBookingContract.View view;


    @Override
    public void start() {

    }

    @Override
    public void stop() {
        this.view = null;
    }
}