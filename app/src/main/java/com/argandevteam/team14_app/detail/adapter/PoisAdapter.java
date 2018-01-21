package com.argandevteam.team14_app.detail.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.argandevteam.team14_app.R;
import com.argandevteam.team14_app.data.Poi;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by pablorojas on 20/1/18.
 */

public class PoisAdapter extends RecyclerView.Adapter<PoisAdapter.MyViewHolder> {

    private Context context;
    private List<Poi> pois;

    public PoisAdapter(Context context) {
        this.context = context;
        pois = new ArrayList<>();
    }

    public void updateList(List<Poi> list) {
        pois.clear();
        pois.addAll(list);
        this.notifyDataSetChanged();
    }

    @Override
    public PoisAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_pois_adapter, parent, false);
        return new PoisAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PoisAdapter.MyViewHolder holder, int position) {
        holder.nameTxt.setText(pois.get(position).getName());
        Glide.with(context).load(pois.get(position).getImage()).apply(RequestOptions.circleCropTransform()).into(holder.poiImg);
    }


    @Override
    public int getItemCount() {
        return pois.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.txt_name)
        TextView nameTxt;

        @BindView(R.id.img_poi)
        ImageView poiImg;


        public MyViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
            v.setOnClickListener(this);
            Typeface soho = Typeface.createFromAsset(context.getAssets(), context.getResources().getString(R.string.sohofont));
            nameTxt.setTypeface(soho);

        }

        @Override
        public void onClick(View view) {

        }
    }


}
