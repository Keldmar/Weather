package com.example.yazon.weather.responseForecast;

import com.example.yazon.weather.responseWeather.Clouds;
import com.example.yazon.weather.responseWeather.Main;
import com.example.yazon.weather.responseWeather.Sys;
import com.example.yazon.weather.responseWeather.Weath;
import com.example.yazon.weather.responseWeather.Wind;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Yazon on 05.07.2017.
 */

public class WeatherForThreeHours implements Serializable {
    public Long dt;
    public Main main;
    public List<Weath> weather;
    public Clouds clouds;
    public Wind wind;
    public Rain rain;
    public Sys sys;
    public String dt_txt;


}
