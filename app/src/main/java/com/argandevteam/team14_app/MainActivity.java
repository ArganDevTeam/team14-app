package com.argandevteam.team14_app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.argandevteam.team14_app.booking.BookingFragment;
import com.argandevteam.team14_app.booking.BookingPresenter;
import com.argandevteam.team14_app.data.source.UsersRepository;
import com.argandevteam.team14_app.data.source.remote.UsersRemoteDataSource;
import com.argandevteam.team14_app.detail.DetailFragment;
import com.argandevteam.team14_app.detail.DetailPresenter;
import com.argandevteam.team14_app.places.PlacesFragment;
import com.argandevteam.team14_app.places.PlacesPresenter;
import com.argandevteam.team14_app.prebooking.PreBookingFragment;
import com.argandevteam.team14_app.prebooking.PreBookingPresenter;

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
                    .addToBackStack(null)
                    .commit();
        }
        UsersRemoteDataSource usersRemoteDataSource = UsersRemoteDataSource.getInstance();

        UsersRepository usersRepository = new UsersRepository(usersRemoteDataSource);

        new DetailPresenter(usersRepository, detailFragment);
    }


    public void navigateToBooking() {
        BookingFragment bookingFragment = (BookingFragment) getSupportFragmentManager().findFragmentByTag(BookingFragment.TAG);
        if (bookingFragment == null) {
            bookingFragment = BookingFragment.newInstance("http://www.booking.com");

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, bookingFragment)
                    .addToBackStack(null)
                    .commit();

        }

        new BookingPresenter(bookingFragment);

    }

    public void navigateToPreBooking() {
        PreBookingFragment preBookingFragment = (PreBookingFragment) getSupportFragmentManager().findFragmentByTag(PreBookingFragment.TAG);
        if (preBookingFragment == null) {
            preBookingFragment = PreBookingFragment.newInstance("http://www.booking.com");

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, preBookingFragment)
                    .addToBackStack(null)
                    .commit();

        }

        new PreBookingPresenter(preBookingFragment);
    }
}
