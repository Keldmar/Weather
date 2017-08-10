package com.yahnenko.app.weather;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.yahnenko.app.weather.response.forecast.Forecast;
import com.yahnenko.app.weather.adapters.RecyclerViewAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class ShowForecastActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forecast);
        String name = getIntent().getStringExtra("name");
        final RecyclerView recyclerView = (RecyclerView)findViewById(R.id.rv);
        WeatherApplication.getApiManager().forecast(name).enqueue(new Callback<Forecast>() {
            @Override
            public void onResponse(Call<Forecast> call, Response<Forecast> response) {
            Forecast forecast = response.body();
                RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(forecast.list);
                recyclerView.setAdapter(recyclerViewAdapter);
            }

            @Override
            public void onFailure(Call<Forecast> call, Throwable t) {

            }
        });
    }
}
