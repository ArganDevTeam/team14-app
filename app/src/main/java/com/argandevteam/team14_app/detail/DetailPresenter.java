package com.argandevteam.team14_app.detail;

/**
 * Created by pablorojas on 20/1/18.
 */

public class DetailPresenter implements DetailContract.Presenter {


    private DetailContract.View view;

    public DetailPresenter(DetailContract.View view) {
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
