package com.yahnenko.app.weather;

import android.app.Application;
import android.content.Context;

import com.yahnenko.app.weather.api.ApiManager;
import com.yahnenko.app.weather.prefs.PreferencesManager;

public class WeatherApplication extends Application {

    private static ApiManager apiManager;
    private static PreferencesManager preferencesManager;

    public static ApiManager getApiManager() {
        return apiManager;
    }

    public static PreferencesManager getPreferencesManager() {
        return preferencesManager;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        apiManager = new ApiManager();
        preferencesManager = new PreferencesManager(getSharedPreferences("hui", Context.MODE_PRIVATE));
    }
}
