package com.argandevteam.team14_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.argandevteam.team14_app.data.source.UsersRepository;
import com.argandevteam.team14_app.data.source.remote.UsersRemoteDataSource;
import com.argandevteam.team14_app.detail.DetailFragment;
import com.argandevteam.team14_app.detail.DetailPresenter;
import com.argandevteam.team14_app.map.MapFragment;
import com.argandevteam.team14_app.map.MapPresenter;
import com.argandevteam.team14_app.places.PlacesFragment;
import com.argandevteam.team14_app.places.PlacesPresenter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigateToPlaces();
    }

    private void navigateToPlaces() {
        PlacesFragment placesFragment = (PlacesFragment) getSupportFragmentManager().findFragmentByTag(PlacesFragment.TAG);

        if (placesFragment == null) {
            placesFragment = PlacesFragment.newInstance();

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, placesFragment)
                    .commit();
        }

        UsersRemoteDataSource usersRemoteDataSource = UsersRemoteDataSource.getInstance();

        UsersRepository usersRepository = new UsersRepository(usersRemoteDataSource);

        PlacesPresenter placesPresenter = new PlacesPresenter(usersRepository, placesFragment);
    }

    public void navigateToDetail() {
        DetailFragment detailFragment = (DetailFragment) getSupportFragmentManager().findFragmentByTag(DetailFragment.TAG);

        if (detailFragment == null) {
            detailFragment = DetailFragment.newInstance();

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, detailFragment)
                    .commit();
        }
        UsersRemoteDataSource usersRemoteDataSource = UsersRemoteDataSource.getInstance();

        UsersRepository usersRepository = new UsersRepository(usersRemoteDataSource);

        new DetailPresenter(usersRepository, detailFragment);
    }


    private void navigateToMap() {
        MapFragment mapFragment = (MapFragment) getSupportFragmentManager().findFragmentByTag(MapFragment.TAG);

        if (mapFragment == null) {
            mapFragment = MapFragment.newInstance();

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, mapFragment)
                    .commit();
        }

        MapPresenter mapPresenter = new MapPresenter(mapFragment);
    }


}
