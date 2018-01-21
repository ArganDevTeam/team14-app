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
        wvBooking.loadUrl("https://www.booking.com/hotel/it/quirinale.en-gb.html?aid=812878;label=metaskyscan-hotel-80040_lang-en_curr-GBP_clkid-7ddd9b1afeac11e7acbb7f206406bee0;sid=d547c36355985125d2a5b125f23e09c4;checkin=2018-02-21;checkout=2018-02-22;ucfs=1;srpvid=52915cad5d540131;srepoch=1516540253;highlighted_blocks=8004019_93707588_0_1_0;all_sr_blocks=8004019_93707588_0_1_0;bshb=2;room1=A%2CA;hpos=1;hapos=1;dest_type=city;dest_id=-126693;srfid=2a282fdb4e5a95d74f0eb7ef2428af5e5d4cfa18X1;from=searchresults;highlight_room=#hotelTmpl");
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
