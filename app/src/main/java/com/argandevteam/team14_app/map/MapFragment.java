package com.argandevteam.team14_app.map;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.argandevteam.team14_app.R;
import com.argandevteam.team14_app.data.Hotel;
import com.argandevteam.team14_app.data.MyMapMarkers;
import com.argandevteam.team14_app.data.Poi;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class MapFragment extends Fragment implements MapContract.View, OnMapReadyCallback {


    public static final String TAG = "MapFragment";
    private MapContract.Presenter presenter;

    @BindView(R.id.map_map)
    MapView map;
    private GoogleMap gmap;
    private static LatLng latLng;

    public MapFragment() {
        // Required empty public constructor
    }

    public static MapFragment newInstance(LatLng ll) {
        latLng = ll;
        return new MapFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_map, container, false);
        ButterKnife.bind(this, v);
        map.onCreate(savedInstanceState);
        initFragment();
        return v;
    }

    private void initFragment() {
        map.onResume();
        try {
            MapsInitializer.initialize(getContext());
        } catch (Exception e) {

        }
        map.getMapAsync(this);

    }


    private void loadMarkers() {
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLng, 12);
        gmap.animateCamera(cameraUpdate);

        for (Hotel hotel : MyMapMarkers.getInstance().getHotelList()) {
            gmap.addMarker(new MarkerOptions()
                    .position(new LatLng(hotel.getLatitude(), hotel.getLongitude()))
                    .title(hotel.getName()));
        }
        for (Poi poi : MyMapMarkers.getInstance().getPoiList()) {
            gmap.addMarker(new MarkerOptions()
                    .position(new LatLng(poi.getLatitude(), poi.getLongitude()))
                    .title(poi.getName()));
        }

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
