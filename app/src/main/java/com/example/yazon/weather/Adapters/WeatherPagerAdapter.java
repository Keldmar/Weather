package com.example.yazon.weather.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class WeatherPagerAdapter extends FragmentPagerAdapter {

    private List<WeatherForOneDay> listeds;

    public WeatherPagerAdapter(FragmentManager fm, List<WeatherForOneDay> listed) {
        super(fm);
        this.listeds = listed;
    }

    @Override
    public Fragment getItem(int position) {
        return WeatherPagerFragment.getInstance(listeds.get(position));
    }

    @Override
    public int getCount() {
        return listeds.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "hui      " + String.valueOf(position);
    }
}
