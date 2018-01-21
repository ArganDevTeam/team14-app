package com.argandevteam.team14_app.detail;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.argandevteam.team14_app.R;
import com.argandevteam.team14_app.data.Detail;
import com.argandevteam.team14_app.detail.adapter.HotelsAdapter;
import com.argandevteam.team14_app.detail.adapter.PoisAdapter;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

import org.w3c.dom.Text;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment implements DetailContract.View, OnMapReadyCallback {


    public static final String TAG = "DetailFragment";
    private DetailContract.Presenter presenter;

    @BindView(R.id.txt_city)
    TextView cityTxt;
    @BindView(R.id.txt_hotel_title)
    TextView hotelTitleText;
    @BindView(R.id.txt_pois_title)
    TextView poisTitleText;
    @BindView(R.id.rv_hotels)
    RecyclerView hotelsRV;
    @BindView(R.id.rv_pois)
    RecyclerView poisRV;

    @BindView(R.id.map_detail)
    MapView map;
    private GoogleMap gmap;

    private HotelsAdapter hotelsAdapter;
    private PoisAdapter poisAdapter;


    public DetailFragment() {


    }

    public static DetailFragment newInstance() {
        return new DetailFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_detail, container, false);
        ButterKnife.bind(this, v);
        map.onCreate(savedInstanceState);
        map.onResume();
        try{
            MapsInitializer.initialize(getContext());
        }catch (Exception e){

        }
        map.getMapAsync(this);
        initFragment();
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.start();
    }

    private void initFragment() {

        hotelsAdapter = new HotelsAdapter(getContext());
        GridLayoutManager hotelsGlm = new GridLayoutManager(getActivity(), 1);
        hotelsRV.setLayoutManager(hotelsGlm);
        hotelsRV.setItemAnimator(new DefaultItemAnimator());
        hotelsRV.setNestedScrollingEnabled(false);
        hotelsRV.setAdapter(hotelsAdapter);

        poisAdapter = new PoisAdapter(getContext());
        GridLayoutManager poisGlm = new GridLayoutManager(getActivity(), 1);
        poisRV.setLayoutManager(poisGlm);
        poisRV.setItemAnimator(new DefaultItemAnimator());
        poisRV.setNestedScrollingEnabled(false);
        poisRV.setAdapter(poisAdapter);

        Typeface soho = Typeface.createFromAsset(getContext().getAssets(), getContext().getResources().getString(R.string.sohofont));
        cityTxt.setTypeface(soho);
        hotelTitleText.setTypeface(soho);
        poisTitleText.setTypeface(soho);

    }

    private void setMapPosition() {
        cityTxt.setText("Madrid");
        double lat = 40.415363;
        double lon = -3.707398;
        LatLng latLng = new LatLng(lat, lon);
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLng, 10);
        gmap.animateCamera(cameraUpdate);
        gmap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {

            }
        });
        gmap.getUiSettings().setScrollGesturesEnabled(false);
    }

    @Override
    public void setPresenter(DetailContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setDetail(Detail detail) {
        hotelsAdapter.updateList(Arrays.asList(detail.getHotels()));
        poisAdapter.updateList(Arrays.asList(detail.getPois()));
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.gmap = googleMap;
        setMapPosition();
    }
}
