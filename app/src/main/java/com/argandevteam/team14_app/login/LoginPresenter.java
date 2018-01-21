package com.argandevteam.team14_app.login;

import com.argandevteam.team14_app.data.User;
import com.argandevteam.team14_app.data.source.UsersDataSource;
import com.argandevteam.team14_app.data.source.UsersRepository;

/**
 * Created by markc on 20/01/2018.
 */

public class LoginPresenter implements LoginContract.Presenter {

    LoginContract.View view;
    UsersRepository usersRepository;

    public LoginPresenter(UsersRepository usersRepository, LoginContract.View view) {
        this.usersRepository = usersRepository;
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

    @Override
    public void onLoginButtonClicked(final String userName) {
        usersRepository.getUser(userName, new UsersDataSource.LoadUserCallback() {
            @Override
            public void onUserCallback(User user) {
                view.navigateToPlaces(userName);
            }

            @Override
            public void onError() {
                view.showError();
            }
        });
    }
}
