package com.example.yazon.weather;


import com.example.yazon.weather.responseForecast.Forecast;
import com.example.yazon.weather.responseWeather.GetWeather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Openweathermap {
    @GET("weather")
    Call<GetWeather> getweather(@Query("q") String cityname, @Query("APPID")String KEY);
    @GET("forecast")
    Call<Forecast> forecast(@Query("q") String cityname, @Query("APPID")String KEY);
}
