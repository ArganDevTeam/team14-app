package com.argandevteam.team14_app.places;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.argandevteam.team14_app.R;
import com.argandevteam.team14_app.data.Place;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by markc on 20/01/2018.
 */

public class PlacesAdapter extends RecyclerView.Adapter<PlacesAdapter.ViewHolder> {

    private final ItemClickListener itemClickListener;
    List<Place> placesList = new ArrayList<>();

    public PlacesAdapter(List<Place> placesList, ItemClickListener itemClickListener) {
        this.placesList = placesList;
        this.itemClickListener = itemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.place_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(view, itemClickListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Place place = placesList.get(position);
        holder.tvPlaceName.setText(place.getName());
        holder.city = place.getName();
    }

    @Override
    public int getItemCount() {
        return placesList == null ? 0 : placesList.size();
    }

    public void setPlacesList(List<Place> placesList) {
        this.placesList = placesList;
    }

    public interface ItemClickListener {
        void onClick(View view, String city);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final ItemClickListener itemClickListener;

        private String city;

        @BindView(R.id.iv_place_image)
        ImageView ivPlaceImage;

        @BindView(R.id.tv_place_name)
        TextView tvPlaceName;

        ViewHolder(View itemView, ItemClickListener itemClickListener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
            this.itemClickListener = itemClickListener;
        }

        @Override
        public void onClick(View view) {
            itemClickListener.onClick(view, city);
        }
    }
}
