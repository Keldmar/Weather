package com.example.yazon.weather;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.yazon.weather.Adapters.WeatherForOneDay;
import com.example.yazon.weather.Adapters.WeatherPagerAdapter;
import com.example.yazon.weather.responseForecast.Forecast;
import com.example.yazon.weather.responseForecast.WeatherForThreeHours;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

    private List<WeatherForOneDay> convertWeather(List<WeatherForThreeHours> list) {

        List<WeatherForOneDay> oneDayList = new ArrayList<WeatherForOneDay>();
        WeatherForOneDay day = new WeatherForOneDay();
        for (int i = 0; i < list.size(); i++) {
            if (day.weatherForThreeHoursList.isEmpty()) {
                day.weatherForThreeHoursList.add(list.get(i));
            } else {
                Date previousDate = new Date(list.get(i - 1).dt * 1000);
                Date date = new Date(list.get(i).dt * 1000);
                SimpleDateFormat sdf = new SimpleDateFormat("dd");
                if (sdf.format(date).equals(sdf.format(previousDate))) {
                    day.weatherForThreeHoursList.add(list.get(i));
                } else {
                    oneDayList.add(day);
                    day =  new WeatherForOneDay();
                }
            }
        }
        return oneDayList;
//        WeatherForOneDay firstDay = new WeatherForOneDay();
//        WeatherForOneDay secondDay = new WeatherForOneDay();
//        WeatherForOneDay thirdDay = new WeatherForOneDay();
//        WeatherForOneDay forthDay = new WeatherForOneDay();
//        WeatherForOneDay fifthDay = new WeatherForOneDay();
//        firstDay.weatherForThreeHoursList.addAll(list.subList(0, 7));
//        secondDay.weatherForThreeHoursList.addAll(list.subList(8, 15));
//        thirdDay.weatherForThreeHoursList.addAll(list.subList(16, 23));
//        forthDay.weatherForThreeHoursList.addAll(list.subList(25, 31));
//        fifthDay.weatherForThreeHoursList.addAll(list.subList(32, 39));
//        List<WeatherForOneDay> oneDayList = new ArrayList<WeatherForOneDay>();
//        oneDayList.add(firstDay);
//        oneDayList.add(secondDay);
//        oneDayList.add(thirdDay);
//        oneDayList.add(forthDay);
//        oneDayList.add(fifthDay);
    }
}
