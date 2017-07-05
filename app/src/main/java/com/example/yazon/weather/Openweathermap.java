package com.example.yazon.weather;


import com.example.yazon.weather.answer.GetWeather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Openweathermap {
    @GET("weather")
    Call<GetWeather> tmp(@Query("q") String cityname, @Query("APPID")String KEY);
}
