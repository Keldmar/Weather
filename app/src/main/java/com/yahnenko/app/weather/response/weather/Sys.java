package com.yahnenko.app.weather.response.weather;

import java.io.Serializable;

public class Sys implements Serializable {
    public Integer type;
    public Integer id;
    public Double message;
    public String country;
    public Integer sunrise;
    public Integer sunset;

    public String d;
}
