package com.example.yazon.weather.responseForecast;


import java.io.Serializable;
import java.util.List;

public class Forecast implements Serializable {
    public Integer cod;
    public Double message;
    public Integer cnt;
    public List<WeatherForThreeHours> list;
    public City cities;
}
