package com.argandevteam.team14_app.prebooking;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.argandevteam.team14_app.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PreBookingFragment extends Fragment implements PreBookingContract.View{


    private PreBookingContract.Presenter presenter;

    public PreBookingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pre_booking, container, false);
    }

    @Override
    public void setPresenter(PreBookingContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
