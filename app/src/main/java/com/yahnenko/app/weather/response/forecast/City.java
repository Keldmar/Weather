package com.yahnenko.app.weather.response.forecast;

import com.yahnenko.app.weather.response.weather.Coord;

import java.io.Serializable;

/**
 * Created by Yazon on 05.07.2017.
 */

public class City implements Serializable {
    public Integer id;
    public String name;
    public Coord coord;
    public String country;
}
