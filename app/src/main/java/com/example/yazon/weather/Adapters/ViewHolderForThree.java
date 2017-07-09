package com.example.yazon.weather.Adapters;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.yazon.weather.R;
import com.example.yazon.weather.responseForecast.WeatherForThreeHours;

/**
 * Created by Yazon on 08.07.2017.
 */

public class ViewHolderForThree extends RecyclerView.ViewHolder {
    private TextView data;
    private TextView temp;
    private ImageView icon;

    public ViewHolderForThree(View itemView) {
        super(itemView);
        data = (TextView) itemView.findViewById(R.id.text_item_data);
        temp = (TextView) itemView.findViewById(R.id.text_item_temp);
        icon = (ImageView) itemView.findViewById(R.id.image_item);
    }

    public void bindData(WeatherForThreeHours listed) {
        data.setText(listed.dt_txt + " - ");
        temp.setText(Float.toString(Math.round(listed.main.temp- 273.15f)) + "°");
        Uri uri = Uri.parse("http://openweathermap.org/img/w/" + listed.weather.get(0).icon + ".png");

        Glide.with(itemView.getContext())
                .load(uri)
                .into(icon);
    }
}