package com.argandevteam.team14_app.booking;

import com.argandevteam.team14_app.booking.BookingContract.Presenter;

/**
 * Created by markc on 21/01/2018.
 */

public class BookingPresenter implements BookingContract.Presenter {


    BookingContract.View view;

    public BookingPresenter(BookingContract.View view) {
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
