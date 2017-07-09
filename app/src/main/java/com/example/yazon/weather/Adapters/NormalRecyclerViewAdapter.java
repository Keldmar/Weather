package com.example.yazon.weather.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yazon.weather.R;
import com.example.yazon.weather.responseForecast.WeatherForThreeHours;

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
