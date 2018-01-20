package com.argandevteam.team14_app;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.argandevteam.team14_app.data.source.UsersRepository;
import com.argandevteam.team14_app.data.source.remote.UsersRemoteDataSource;
import com.argandevteam.team14_app.detail.DetailFragment;
import com.argandevteam.team14_app.detail.DetailPresenter;
import com.argandevteam.team14_app.login.LoginPresenter;

public class MainActivity extends AppCompatActivity {

    private UsersRepository usersRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UsersRemoteDataSource usersRemoteDataSource = UsersRemoteDataSource.getInstance();
        usersRepository = new UsersRepository(usersRemoteDataSource);

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
        new DetailPresenter(usersRepository, detailFragment);
    }


}
