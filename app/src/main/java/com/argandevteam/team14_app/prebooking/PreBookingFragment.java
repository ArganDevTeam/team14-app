package com.argandevteam.team14_app.prebooking;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.argandevteam.team14_app.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class PreBookingFragment extends Fragment implements PreBookingContract.View {


    @BindView(R.id.wv_booking)
    WebView wvBooking;
    private PreBookingContract.Presenter presenter;

    public PreBookingFragment() {
        // Required empty public constructor
    }


    public static PreBookingFragment newInstance(String bookingUrl){
        Bundle args = new Bundle();
        args.putString(bookingUrl, "bookingUrl");
        PreBookingFragment preBookingFragment = new PreBookingFragment();
        preBookingFragment.setArguments(args);
        return preBookingFragment;
    }

    

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pre_booking, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onDestroy() {
        presenter.stop();
        super.onDestroy();
    }

    @Override
    public void setPresenter(PreBookingContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
