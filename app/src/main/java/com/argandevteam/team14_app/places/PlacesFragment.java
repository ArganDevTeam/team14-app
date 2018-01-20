package com.argandevteam.team14_app.places;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.argandevteam.team14_app.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlacesFragment extends Fragment implements PlacesContract.View{


    private PlacesContract.Presenter presenter;

    public PlacesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_places, container, false);
    }

    @Override
    public void onDestroy() {
        presenter.stop();
        super.onDestroy();
    }

    @Override
    public void setPresenter(PlacesContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
