package com.yahnenko.app.weather;


import com.yahnenko.app.weather.response.forecast.Forecast;
import com.yahnenko.app.weather.response.weather.GetWeather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface Openweathermap {
    @GET("weather")
    Call<GetWeather> getweather(@Query("q") String cityname);
    @GET("weather")
    Observable<GetWeather> getweatherRx(@Query("q") String cityname);
    @GET("forecast")
    Call<Forecast> forecast(@Query("q") String cityname);
}
