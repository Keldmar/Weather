package com.yahnenko.app.weather.prefs;

import android.content.SharedPreferences;

/**
 * Created by Yazon on 14.07.2017.
 */

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
