package com.example.yazon.weather.Adapters;

import com.example.yazon.weather.responseForecast.WeatherForThreeHours;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class WeatherForOneDay implements Serializable{
    public List<WeatherForThreeHours> weatherForThreeHoursList;

    public WeatherForOneDay(){
        weatherForThreeHoursList = new ArrayList<>();
    }

}
