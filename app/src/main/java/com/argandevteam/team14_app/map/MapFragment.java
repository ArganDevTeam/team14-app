package com.argandevteam.team14_app.map;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.argandevteam.team14_app.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class MapFragment extends Fragment implements MapContract.View, OnMapReadyCallback{


    public static final String TAG = "MapFragment" ;
    private MapContract.Presenter presenter;

    @BindView(R.id.map_map)
    MapView map;
    private GoogleMap gmap;

    public MapFragment() {
        // Required empty public constructor
    }

    public static MapFragment newInstance() {
        return  new MapFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_map, container, false);
        ButterKnife.bind(this,v);
        map.onCreate(savedInstanceState);
        initFragment();
        return v;
    }

    private void initFragment() {
        map.onResume();
        try{
            MapsInitializer.initialize(getContext());
        }catch (Exception e){

        }
        map.getMapAsync(this);

    }


    private void loadMarkers() {

    }


    @Override
    public void setPresenter(MapContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.gmap = googleMap;
        loadMarkers();
    }


}
