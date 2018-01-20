package com.argandevteam.team14_app.detail;

import com.argandevteam.team14_app.data.Detail;
import com.argandevteam.team14_app.data.source.UsersDataSource;
import com.argandevteam.team14_app.data.source.UsersRepository;

/**
 * Created by pablorojas on 20/1/18.
 */

public class DetailPresenter implements DetailContract.Presenter {


    private DetailContract.View view;
    UsersRepository usersRepository;

    public DetailPresenter(UsersRepository usersRepository, DetailContract.View view) {
        this.view = view;
        this.usersRepository = usersRepository;
        view.setPresenter(this);
    }

    @Override
    public void start() {
        usersRepository.getDetail(new UsersDataSource.LoadDetailCallback() {
            @Override
            public void onDetailCallback(Detail detail) {
                view.setDetail(detail);
            }

            @Override
            public void onError() {

            }
        });
    }

    @Override
    public void stop() {
        view = null;
    }
}
