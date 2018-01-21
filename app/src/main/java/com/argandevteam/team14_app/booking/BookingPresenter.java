package com.argandevteam.team14_app.booking;

/**
 * Created by markc on 21/01/2018.
 */

public class BookingPresenter implements BookingContract.Presenter {


    BookingContract.View view;

    public BookingPresenter(BookingContract.View view) {
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {
        view = null;
    }
}
