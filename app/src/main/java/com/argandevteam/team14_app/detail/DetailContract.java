package com.argandevteam.team14_app.detail;

import com.argandevteam.team14_app.BasePresenter;
import com.argandevteam.team14_app.BaseView;
import com.argandevteam.team14_app.data.Detail;
import com.argandevteam.team14_app.places.PlacesContract;

/**
 * Created by pablorojas on 20/1/18.
 */

public interface DetailContract {

    interface View extends BaseView<DetailContract.Presenter> {
        void setDetail(Detail detail);
    }

    interface Presenter extends BasePresenter {

    }
}
