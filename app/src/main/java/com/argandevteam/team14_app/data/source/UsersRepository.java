package com.argandevteam.team14_app.data.source;

import com.argandevteam.team14_app.data.User;

/**
 * Created by markc on 20/01/2018.
 */

public class UsersRepository implements UsersDataSource{

    private UsersDataSource remoteDataSource;

    public UsersRepository(UsersDataSource remoteDataSource) {
        this.remoteDataSource = remoteDataSource;
    }

    @Override
    public void getUser(final LoadUserCallback callback) {
        remoteDataSource.getUser(new LoadUserCallback() {
            @Override
            public void onUserCallback(User user) {
                callback.onUserCallback(user);
            }

            @Override
            public void onError() {
                callback.onError();
            }
        });
    }
}
