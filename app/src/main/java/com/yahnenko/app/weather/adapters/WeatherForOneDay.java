package com.yahnenko.app.weather.adapters;

import com.yahnenko.app.weather.response.forecast.WeatherForThreeHours;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class WeatherForOneDay implements Serializable{
    public List<WeatherForThreeHours> weatherForThreeHoursList;

    public WeatherForOneDay(){
        weatherForThreeHoursList = new ArrayList<>();
    }

}
