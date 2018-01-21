package com.argandevteam.team14_app.detail;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.argandevteam.team14_app.MainActivity;
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

    private static String cityName;

    private HotelsAdapter hotelsAdapter;
    private PoisAdapter poisAdapter;
    private MainActivity mainActivity;
    private HotelsAdapter.ItemClickListener itemClickListener = new HotelsAdapter.ItemClickListener() {
        @Override
        public void onClick(View view, int position) {
            mainActivity.navigateToPreBooking();
        }
    };

    public DetailFragment() {


    }

    public static DetailFragment newInstance(String city) {
        cityName = city;
        return new DetailFragment();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_detail, container, false);
        ButterKnife.bind(this, v);
        mainActivity = (MainActivity) getActivity();
        map.onCreate(savedInstanceState);
        initFragment();
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.start();
    }

    private void initFragment() {
        map.onResume();
        try{
            MapsInitializer.initialize(getContext());
        }catch (Exception e){

        }
        map.getMapAsync(this);

        hotelsAdapter = new HotelsAdapter(getContext(), itemClickListener);
        LinearLayoutManager hotelsLayoutManager = new LinearLayoutManager(getActivity());
        hotelsRV.setLayoutManager(hotelsLayoutManager);
        hotelsRV.setItemAnimator(new DefaultItemAnimator());
        hotelsRV.setNestedScrollingEnabled(false);
        hotelsRV.setAdapter(hotelsAdapter);

        poisAdapter = new PoisAdapter(getContext());
        LinearLayoutManager poisLayoutManager = new LinearLayoutManager(getActivity());
        poisRV.setLayoutManager(poisLayoutManager);
        poisRV.setItemAnimator(new DefaultItemAnimator());
        poisRV.setNestedScrollingEnabled(false);
        poisRV.setAdapter(poisAdapter);

        Typeface soho = Typeface.createFromAsset(getContext().getAssets(), getContext().getResources().getString(R.string.sohofont));
        cityTxt.setTypeface(soho);
        hotelTitleText.setTypeface(soho);
        poisTitleText.setTypeface(soho);

    }

    private void setMapPosition() {
        cityTxt.setText(cityName);
        double lat = 40.415363;
        double lon = -3.707398;
        LatLng latLng = new LatLng(lat, lon);
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLng, 10);
        gmap.animateCamera(cameraUpdate);
        gmap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                ((MainActivity)getActivity()).navigateToMap(latLng);
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
