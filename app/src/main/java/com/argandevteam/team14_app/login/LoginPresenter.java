package com.argandevteam.team14_app.login;

/**
 * Created by markc on 20/01/2018.
 */

public class LoginPresenter implements LoginContract.Presenter {

    LoginContract.View view;

    public LoginPresenter(LoginContract.View view) {
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
