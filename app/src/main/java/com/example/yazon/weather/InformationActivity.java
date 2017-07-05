package com.example.yazon.weather;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.yazon.weather.answer.GetWeather;

/**
 * Created by Yazon on 04.07.2017.
 */

public class InformationActivity extends Activity {

    private TextView info;
    private TextView nameinfo;
    private ImageView image;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information);

        info = (TextView) findViewById(R.id.info);
        nameinfo = (TextView) findViewById(R.id.nameinfo);
        image = (ImageView) findViewById(R.id.image);
        GetWeather weather = (GetWeather) getIntent().getExtras().getSerializable("temp");

        nameinfo.setText(weather.name + ", " + weather.sys.country);
        info.setText(getString(R.string.informatoin,
                weather.main.temp - 273.15f,
                weather.wind.speed,
                weather.main.pressure,
                weather.main.humidity));

        Uri uri = Uri.parse("http://openweathermap.org/img/w/" + weather.weather.get(0).icon + ".png");

        Glide
                .with(this)
                .load(uri)
                .into(image);
    }
}