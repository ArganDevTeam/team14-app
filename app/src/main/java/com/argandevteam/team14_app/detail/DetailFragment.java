package com.argandevteam.team14_app.detail;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.argandevteam.team14_app.MainActivity;
import com.argandevteam.team14_app.R;
import com.argandevteam.team14_app.data.Detail;
import com.argandevteam.team14_app.detail.adapter.HotelsAdapter;
import com.argandevteam.team14_app.detail.adapter.PoisAdapter;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment implements DetailContract.View {


    public static final String TAG = "DetailFragment";
    @BindView(R.id.txt_city)
    TextView cityTxt;
    @BindView(R.id.txt_hotel_title)
    TextView hotelTitleText;
    @BindView(R.id.txt_pois_title)
    TextView poisTitleText;
    @BindView(R.id.rv_hotels)
    RecyclerView hotelsRV;
    @BindView(R.id.rv_pois)
    RecyclerView poisRV;
    private DetailContract.Presenter presenter;
    private HotelsAdapter hotelsAdapter;
    private PoisAdapter poisAdapter;
    private MainActivity mainActivity;
    private HotelsAdapter.ItemClickListener itemClickListener = new HotelsAdapter.ItemClickListener() {
        @Override
        public void onClick(View view) {
            mainActivity.navigateToPreBooking();
        }
    };

    public DetailFragment() {


    }

    public static DetailFragment newInstance() {
        return new DetailFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_detail, container, false);
        ButterKnife.bind(this, v);
        mainActivity = (MainActivity) getActivity();
        initFragment();
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.start();
    }

    private void initFragment() {

        hotelsAdapter = new HotelsAdapter(getContext(), itemClickListener);
        LinearLayoutManager hotelsLayoutManager = new LinearLayoutManager(getActivity());
        hotelsRV.setLayoutManager(hotelsLayoutManager);
        hotelsRV.setItemAnimator(new DefaultItemAnimator());
        hotelsRV.setNestedScrollingEnabled(false);
        hotelsRV.setAdapter(hotelsAdapter);

        poisAdapter = new PoisAdapter(getContext());
        LinearLayoutManager poisLayoutManager = new LinearLayoutManager(getActivity());
        poisRV.setLayoutManager(poisLayoutManager);
        poisRV.setItemAnimator(new DefaultItemAnimator());
        poisRV.setNestedScrollingEnabled(false);
        poisRV.setAdapter(poisAdapter);

        Typeface soho = Typeface.createFromAsset(getContext().getAssets(), getContext().getResources().getString(R.string.sohofont));
        cityTxt.setTypeface(soho);
        hotelTitleText.setTypeface(soho);
        poisTitleText.setTypeface(soho);
    }

    @Override
    public void setPresenter(DetailContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setDetail(Detail detail) {
        hotelsAdapter.updateList(Arrays.asList(detail.getHotels()));
        poisAdapter.updateList(Arrays.asList(detail.getPois()));
    }
}
