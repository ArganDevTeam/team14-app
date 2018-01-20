package com.argandevteam.team14_app;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.argandevteam.team14_app.detail.DetailFragment;
import com.argandevteam.team14_app.detail.DetailPresenter;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        DetailPresenter detailPresenter = new DetailPresenter(detailFragment);
    }



}
