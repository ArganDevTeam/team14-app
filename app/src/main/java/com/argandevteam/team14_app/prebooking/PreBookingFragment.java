package com.argandevteam.team14_app.prebooking;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import com.argandevteam.team14_app.MainActivity;
import com.argandevteam.team14_app.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class PreBookingFragment extends Fragment implements PreBookingContract.View {


    public static final String TAG = "PreBookingFragment";
    @BindView(R.id.sp_num_guests)
    Spinner spNumGuests;
    @BindView(R.id.et_start_date)
    EditText etStartDate;
    @BindView(R.id.et_end_date)
    EditText etEndDate;
    private PreBookingContract.Presenter presenter;
    private MainActivity mainActivity;


    public PreBookingFragment() {
        // Required empty public constructor
    }


    public static PreBookingFragment newInstance(String bookingUrl) {
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

        mainActivity = (MainActivity) getActivity();

        ArrayAdapter<CharSequence> spAdapter = ArrayAdapter.createFromResource(getContext(),
                R.array.num_guests_array,
                android.R.layout.simple_spinner_item);

        spAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spNumGuests.setAdapter(spAdapter);


        return view;
    }

    @Override
    public void onDestroy() {
        presenter.stop();
        super.onDestroy();
    }

    @OnClick(R.id.et_start_date)
    void onStartDateClick(View view) {
        showDatePickerDialog(view);
    }

    @OnClick(R.id.et_end_date)
    void onEndDateClick(View view) {
        showDatePickerDialog(view);
    }

    private void showDatePickerDialog(View view) {
        final EditText etClicked = (EditText) view;
        DatePickerFragment newFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                final String selectedDate = twoDigits(day) + "/" + twoDigits(month + 1) + "/" + year;

                etClicked.setText(selectedDate);
            }
        });
        newFragment.show(mainActivity.getFragmentManager(), "DatePicker");
    }



    private String twoDigits(int n) {
        return (n <= 9) ? ("0" + n) : String.valueOf(n);
    }

    @Override
    public void setPresenter(PreBookingContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @OnClick(R.id.btn_booking)
    public void onBookingClicked(View view) {
        mainActivity.navigateToBooking();
    }
}
