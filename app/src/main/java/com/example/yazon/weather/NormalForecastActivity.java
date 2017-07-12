package com.example.yazon.weather;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.yazon.weather.Adapters.WeatherPagerAdapter;
import com.example.yazon.weather.responseForecast.Forecast;
import com.example.yazon.weather.responseForecast.WeatherForThreeHours;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.yazon.weather.Adapters.WeatherConverter.convertWeather;

public class NormalForecastActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_forecast);
        String name = getIntent().getStringExtra("name");
        viewPager = (ViewPager) findViewById(R.id.vp);
        tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(name);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        WeatherApplication.getApiManager().forecast(name).enqueue(new Callback<Forecast>() {
            @Override
            public void onResponse(Call<Forecast> call, Response<Forecast> response) {
                Forecast forecast = response.body();
                List<WeatherForThreeHours> list = forecast.list;
                WeatherPagerAdapter weatherPagerAdapter = new WeatherPagerAdapter(getSupportFragmentManager(), convertWeather(list));
                viewPager.setAdapter(weatherPagerAdapter);
                tabLayout.setupWithViewPager(viewPager);
            }

            @Override
            public void onFailure(Call<Forecast> call, Throwable t) {

            }
        });
    }
}
