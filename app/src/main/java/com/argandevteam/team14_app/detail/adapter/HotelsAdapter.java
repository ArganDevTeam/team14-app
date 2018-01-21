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
import com.argandevteam.team14_app.data.Hotel;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by pablorojas on 20/1/18.
 */

public class HotelsAdapter extends RecyclerView.Adapter<HotelsAdapter.MyViewHolder> {

    private final ItemClickListener itemClickListener;
    private Context context;
    private List<Hotel> hotels;

    public HotelsAdapter(Context context, ItemClickListener itemClickListener) {
        this.context = context;
        this.itemClickListener = itemClickListener;
        hotels = new ArrayList<>();
    }

    public void updateList(List<Hotel> list) {
        hotels.clear();
        hotels.addAll(list);
        this.notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_hotels_adapter, parent, false);
        return new HotelsAdapter.MyViewHolder(itemView, itemClickListener);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.nameTxt.setText(hotels.get(position).getName());
        holder.priceTxt.setText(hotels.get(position).getPrice() + "€");
        Glide.with(context).load(hotels.get(position).getImage()).apply(RequestOptions.circleCropTransform()).into(holder.hotelImg);
    }


    @Override
    public int getItemCount() {
        return hotels.size();
    }

    public interface ItemClickListener {
        void onClick(View view);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final ItemClickListener itemClickListener;
        @BindView(R.id.img_hotel)
        ImageView hotelImg;

        @BindView(R.id.txt_name)
        TextView nameTxt;

        @BindView(R.id.txt_price)
        TextView priceTxt;


        public MyViewHolder(View v, ItemClickListener itemClickListener) {
            super(v);
            ButterKnife.bind(this, v);
            v.setOnClickListener(this);
            this.itemClickListener = itemClickListener;
            Typeface soho = Typeface.createFromAsset(context.getAssets(), context.getResources().getString(R.string.sohofont));
            nameTxt.setTypeface(soho);
            priceTxt.setTypeface(soho);
        }

        @Override
        public void onClick(View view) {
            itemClickListener.onClick(view);
        }
    }


}
