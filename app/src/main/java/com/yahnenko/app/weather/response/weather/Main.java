package com.yahnenko.app.weather.response.weather;

import java.io.Serializable;



public class Main implements Serializable {
    public Float temp;
    public Float pressure;
    public Float humidity;
    public Double temp_min;
    public Double temp_max;

    public Double sea_level;
    public Double grnd_level;
    public Double temp_kf;

}
