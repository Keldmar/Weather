package com.yahnenko.app.weather.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yahnenko.app.weather.R;
import com.yahnenko.app.weather.response.forecast.WeatherForThreeHours;

import java.util.List;

/**
 * Created by Yazon on 08.07.2017.
 */

public class NormalRecyclerViewAdapter extends RecyclerView.Adapter<ViewHolderForThree>  {

    private List<WeatherForThreeHours> listeds;

    public NormalRecyclerViewAdapter(List<WeatherForThreeHours> listed) {
        this.listeds = listed;
    }

    @Override
    public ViewHolderForThree onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.weather_item, parent, false);
        return new ViewHolderForThree(v);
    }

    @Override
    public void onBindViewHolder(ViewHolderForThree holder, int position) {
        holder.bindData(listeds.get(position));
    }

    @Override
    public int getItemCount() {
        return listeds.size();
    }
}
