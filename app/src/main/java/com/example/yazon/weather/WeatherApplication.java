package com.example.yazon.weather;

import android.app.Application;

import com.example.yazon.weather.api.ApiManager;

public class WeatherApplication extends Application {

    private static ApiManager apiManager;

    public static ApiManager getApiManager() {
        return apiManager;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        apiManager = new ApiManager();
    }

}
