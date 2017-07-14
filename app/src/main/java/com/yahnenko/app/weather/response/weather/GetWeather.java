package com.yahnenko.app.weather.response.weather;

import java.io.Serializable;
import java.util.List;



public class GetWeather implements Serializable {
    public Coord coord;
    public List<Weath> weather;
    public String base;
    public Main main;
    public Integer visibility;
    public Wind wind;
    public Clouds clouds;
    public Integer dt;
    public Sys sys;
    public Integer id;
    public String name;
    public Integer cod;

}
