package com.argandevteam.team14_app.booking;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.argandevteam.team14_app.R;

import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class BookingFragment extends Fragment implements BookingContract.View {

    BookingContract.Presenter presenter;

    public BookingFragment() {
        // Required empty public constructor
    }

    public static BookingFragment newInstance(String bookingUrl) {
        Bundle args = new Bundle();
        args.putString(bookingUrl, "bookingUrl");
        BookingFragment bookingFragment = new BookingFragment();
        bookingFragment.setArguments(args);
        return bookingFragment;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.start();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_booking, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onDestroy() {
        presenter.stop();
        super.onDestroy();
    }

    @Override
    public void setPresenter(BookingContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
