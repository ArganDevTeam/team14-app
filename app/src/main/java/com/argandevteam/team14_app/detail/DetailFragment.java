package com.argandevteam.team14_app.detail;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.argandevteam.team14_app.R;
import com.argandevteam.team14_app.detail.adapter.HotelsAdapter;
import com.argandevteam.team14_app.detail.adapter.PoisAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment implements DetailContract.View{


    public static final String TAG = "DetailFragment";
    private DetailContract.Presenter presenter;

    @BindView(R.id.txt_city)
    TextView cityTxt;
    @BindView(R.id.rv_hotels)
    RecyclerView hotelsRV;
    @BindView(R.id.rv_pois)
    RecyclerView poisRV;

    public DetailFragment() {


    }

    public static DetailFragment newInstance(){
        return new DetailFragment();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_detail, container, false);
        ButterKnife.bind(this, v);
        initFragment();
        return v;
    }

    private void initFragment() {

        HotelsAdapter hotelsAdapter = new HotelsAdapter(getContext());
        GridLayoutManager hotelsGlm = new GridLayoutManager(getActivity(), 1);
        hotelsRV.setLayoutManager(hotelsGlm);
        hotelsRV.setItemAnimator(new DefaultItemAnimator());
        hotelsRV.setAdapter(hotelsAdapter);

        PoisAdapter poisAdapter = new PoisAdapter(getContext());
        GridLayoutManager poisGlm = new GridLayoutManager(getActivity(), 1);
        poisRV.setLayoutManager(poisGlm);
        poisRV.setItemAnimator(new DefaultItemAnimator());
        poisRV.setAdapter(poisAdapter);
    }

    @Override
    public void setPresenter(DetailContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
