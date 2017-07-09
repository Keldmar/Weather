package com.example.yazon.weather;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.yazon.weather.responseWeather.GetWeather;

/**
 * Created by Yazon on 04.07.2017.
 */

public class InformationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information);

        TextView info = (TextView) findViewById(R.id.info);
        TextView nameinfo = (TextView) findViewById(R.id.nameinfo);
        ImageView image = (ImageView) findViewById(R.id.image);
        Button button = (Button) findViewById(R.id.show);
        Button button2 = (Button) findViewById(R.id.normal_show);

        final GetWeather weather = (GetWeather) getIntent().getExtras().getSerializable("temp");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InformationActivity.this, ShowForecastActivity.class);
                intent.putExtra("name", weather.name);
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InformationActivity.this, NormalForecastActivity.class);
                intent.putExtra("name", weather.name);
                startActivity(intent);
            }
        });


        nameinfo.setText(weather.name + ", " + weather.sys.country);
        info.setText(getString(R.string.informatoin,
                weather.main.temp - 273.15f,
                weather.wind.speed,
                weather.main.pressure,
                weather.main.humidity));

        WeatherApplication.getApiManager();
        Uri uri = Uri.parse("http://openweathermap.org/img/w/" + weather.weather.get(0).icon + ".png");

        Glide
                .with(this)
                .load(uri)
                .into(image);

    }

}