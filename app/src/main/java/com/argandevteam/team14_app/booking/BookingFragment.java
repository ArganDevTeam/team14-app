package com.argandevteam.team14_app.booking;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.argandevteam.team14_app.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class BookingFragment extends Fragment implements BookingContract.View {

    public static final String TAG = "BookingFragment";
    BookingContract.Presenter presenter;
    @BindView(R.id.wv_booking)
    WebView wvBooking;
    private String bookingUrl;

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
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        bookingUrl = args.getString("bookingUrl");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_booking, container, false);
        ButterKnife.bind(this, view);
        wvBooking.setWebViewClient(new WebViewClient());
        wvBooking.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        wvBooking.loadUrl("https://www.booking.com");
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
