package com.argandevteam.team14_app.detail.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;


import com.argandevteam.team14_app.R;

import java.util.ArrayList;


import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by pablorojas on 20/1/18.
 */

public class HotelsAdapter extends RecyclerView.Adapter<HotelsAdapter.MyViewHolder> {

    private Context context;
    private List<Hotels> hotels;

    public HotelsAdapter(Context context) {
        this.context = context;
        hotels = new ArrayList<>();
    }

    public void updateList(List<Hotels> list) {
        hotels.clear();
        hotels.addAll(list);
        this.notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_hotels_adapter, parent, false);
        return new HotelsAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return hotels.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.txt_name)
        TextView nameTxt;

        @BindView(R.id.txt_price)
        TextView priceTxt;


        public MyViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
            v.setOnClickListener(this);
            Typeface soho = Typeface.createFromAsset(context.getAssets(), context.getResources().getString(R.string.sohofont));
            nameTxt.setTypeface(soho);
            priceTxt.setTypeface(soho);
        }

        @Override
        public void onClick(View view) {
        }
    }


}
