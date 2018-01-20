package com.argandevteam.team14_app.data.source;

import com.argandevteam.team14_app.data.Detail;
import com.argandevteam.team14_app.data.User;

/**
 * Created by markc on 20/01/2018.
 */

public interface UsersDataSource {

    void getUser(LoadUserCallback callback);

    void getDetail(LoadDetailCallback callback);

    interface LoadUserCallback {
        void onUserCallback(User user);

        void onError();
    }

    interface LoadDetailCallback {
        void onDetailCallback(Detail detail);
        void onError();
    }
}
