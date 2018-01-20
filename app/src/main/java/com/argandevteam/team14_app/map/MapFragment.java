package com.argandevteam.team14_app.map;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.argandevteam.team14_app.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MapFragment extends Fragment implements MapContract.View{


    private MapContract.Presenter presenter;

    public MapFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_map, container, false);
    }


    @Override
    public void setPresenter(MapContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
