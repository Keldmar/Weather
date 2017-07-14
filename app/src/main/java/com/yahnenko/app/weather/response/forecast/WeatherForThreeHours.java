package com.yahnenko.app.weather.response.forecast;

import com.yahnenko.app.weather.response.weather.Clouds;
import com.yahnenko.app.weather.response.weather.Main;
import com.yahnenko.app.weather.response.weather.Sys;
import com.yahnenko.app.weather.response.weather.Weath;
import com.yahnenko.app.weather.response.weather.Wind;

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
