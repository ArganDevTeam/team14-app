package com.argandevteam.team14_app.places;

import com.argandevteam.team14_app.BasePresenter;
import com.argandevteam.team14_app.BaseView;
import com.argandevteam.team14_app.data.Place;

import java.util.List;

/**
 * Created by markc on 20/01/2018.
 */

public interface PlacesContract {
    interface View extends BaseView<Presenter> {

        void showLoadPlacesError();

        void showPlaces(List<Place> places);
    }
    interface Presenter extends BasePresenter {

    }
}
