package com.yahnenko.app.weather.util;

import com.yahnenko.app.weather.adapters.WeatherForOneDay;
import com.yahnenko.app.weather.response.forecast.WeatherForThreeHours;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WeatherConverter {
    public static List<WeatherForOneDay> convertWeather(List<WeatherForThreeHours> list) {

        List<WeatherForOneDay> oneDayList = new ArrayList<WeatherForOneDay>();
        WeatherForOneDay day = new WeatherForOneDay();
        for (int i = 0; i < list.size(); i++) {
            if (day.weatherForThreeHoursList.isEmpty()) {
                day.weatherForThreeHoursList.add(list.get(i));
            } else {
                Date previousDate = new Date(list.get(i - 1).dt * 1000);
                Date date = new Date(list.get(i).dt * 1000);
                SimpleDateFormat sdf = new SimpleDateFormat("dd");
                if (sdf.format(date).equals(sdf.format(previousDate))) {
                    day.weatherForThreeHoursList.add(list.get(i));
                } else {
                    oneDayList.add(day);
                    day =  new WeatherForOneDay();
                }
            }
        }
        return oneDayList;
    }
}
