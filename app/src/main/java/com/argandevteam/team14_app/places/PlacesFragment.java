package com.argandevteam.team14_app.places;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.argandevteam.team14_app.MainActivity;
import com.argandevteam.team14_app.R;
import com.argandevteam.team14_app.data.Place;
import com.argandevteam.team14_app.detail.DetailFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlacesFragment extends Fragment implements PlacesContract.View{


    public static final String TAG = "PlacesFragment";
    private PlacesContract.Presenter presenter;
    private MainActivity mainActivity;
    PlacesAdapter.ItemClickListener itemClickListener = new PlacesAdapter.ItemClickListener() {

        @Override
        public void onClick(View view, String city) {
            mainActivity.navigateToDetail(city);
        }
    };

    @BindView(R.id.rv_places)
    RecyclerView rvPlaces;
    private PlacesAdapter placesAdapter;

    public PlacesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.start();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        placesAdapter = new PlacesAdapter(new ArrayList<Place>(0), itemClickListener);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_places, container, false);
        mainActivity = (MainActivity) getActivity();

        ButterKnife.bind(this, view);

        rvPlaces.setAdapter(placesAdapter);

        rvPlaces.setHasFixedSize(true);
        rvPlaces.setItemAnimator(new DefaultItemAnimator());
        rvPlaces.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
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

    @Override
    public void showLoadPlacesError() {
        Toast.makeText(mainActivity, "Cant get places", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showPlaces(List<Place> places) {
        placesAdapter.setPlacesList(places);
        placesAdapter.notifyDataSetChanged();
    }

    public static PlacesFragment newInstance() {
        return new PlacesFragment();
    }
}
