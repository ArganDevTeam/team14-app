package com.argandevteam.team14_app.login;

import com.argandevteam.team14_app.BasePresenter;
import com.argandevteam.team14_app.BaseView;

/**
 * Created by markc on 20/01/2018.
 */

public interface LoginContract {
    interface View extends BaseView<Presenter> {

        void navigateToPlaces(String username);

        void showError();
    }

    interface Presenter extends BasePresenter {

        void onLoginButtonClicked(String userName);
    }
}
