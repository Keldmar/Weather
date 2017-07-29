package com.yahnenko.app.weather.prefs;

import android.content.SharedPreferences;

public class PreferencesManager {
    private static final String KEY_CITY = "KEY_CITY";

    private SharedPreferences sharedPref;

    public PreferencesManager(SharedPreferences sharedPref) {
        this.sharedPref = sharedPref;
    }

    public String getCity(){
        return sharedPref.getString(KEY_CITY, "");
    }
    public void setCity(String city){
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(KEY_CITY, city);
        editor.apply();
    }
}
