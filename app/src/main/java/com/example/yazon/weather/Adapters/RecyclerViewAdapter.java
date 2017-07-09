package com.example.yazon.weather.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yazon.weather.R;
import com.example.yazon.weather.responseForecast.WeatherForThreeHours;

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