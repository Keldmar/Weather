package com.yahnenko.app.weather.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yahnenko.app.weather.R;
import com.yahnenko.app.weather.response.forecast.WeatherForThreeHours;

import java.util.List;

/**
 * Created by Yazon on 05.07.2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<ViewHolderForThree> {
    private List<WeatherForThreeHours> listeds;

    public RecyclerViewAdapter(List<WeatherForThreeHours> listed) {
        this.listeds = listed;
    }

    /**
     * Создание новых View и ViewHolderForThree элемента списка, которые впоследствии могут переиспользоваться.
     */
    @Override
    public ViewHolderForThree onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.weather_item, viewGroup, false);
        return new ViewHolderForThree(v);
    }

    /**
     * Заполнение виджетов View данными из элемента списка с номером i
     */
    @Override
    public void onBindViewHolder(ViewHolderForThree viewHolder, int i) {
        viewHolder.bindData(listeds.get(i));
    }

    @Override
    public int getItemCount() {
        return listeds.size();
    }
}