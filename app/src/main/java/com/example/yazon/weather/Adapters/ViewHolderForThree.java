package com.example.yazon.weather.Adapters;

import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.yazon.weather.R;
import com.example.yazon.weather.responseForecast.WeatherForThreeHours;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Yazon on 08.07.2017.
 */

public class ViewHolderForThree extends RecyclerView.ViewHolder {
    private TextView data;
    private TextView temp;
    private ImageView icon;
    private TextView otherInfo;
    private LinearLayout linearLayout;

    public ViewHolderForThree(View itemView) {
        super(itemView);
        data = (TextView) itemView.findViewById(R.id.text_item_data);
        temp = (TextView) itemView.findViewById(R.id.text_item_temp);
        icon = (ImageView) itemView.findViewById(R.id.image_item);
        otherInfo = (TextView)itemView.findViewById(R.id.other_info);
        linearLayout = (LinearLayout) itemView.findViewById(R.id.rootLayout);
    }

    public void bindData(WeatherForThreeHours listed) {
        Date date = new Date(listed.dt * 1000);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        SimpleDateFormat sdfoflayout = new SimpleDateFormat("HH");
        int time = Integer.valueOf(sdfoflayout.format(date));
        if (time > 5 && time < 10) {
            linearLayout.setBackgroundColor(ContextCompat.getColor(itemView.getContext(), R.color.morning));
        } else {
            if (time > 11 && time < 18) {
                linearLayout.setBackgroundColor(ContextCompat.getColor(itemView.getContext(), R.color.day));
            } else {
                if (time > 17 && time < 22) {
                    linearLayout.setBackgroundColor(ContextCompat.getColor(itemView.getContext(), R.color.evening));
                } else {
                    linearLayout.setBackgroundColor(ContextCompat.getColor(itemView.getContext(), R.color.nights));
                }
            }
        }

        data.setText(sdf.format(date));
        temp.setText(Float.toString(Math.round(listed.main.temp - 273.15f)) + "°");
        otherInfo.setText(itemView.getContext().getString(R.string.information,
                listed.main.humidity,
                listed.main.pressure,
                listed.wind.speed));
        Uri uri = Uri.parse("http://openweathermap.org/img/w/" + listed.weather.get(0).icon + ".png");

        Glide.with(itemView.getContext())
                .load(uri)
                .into(icon);
    }
}