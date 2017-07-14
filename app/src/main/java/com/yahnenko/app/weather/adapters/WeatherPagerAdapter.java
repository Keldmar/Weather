package com.yahnenko.app.weather.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;
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
        Date date = new Date(listeds.get(position).weatherForThreeHoursList.get(position).dt * 1000);
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM");
        return sdf.format(date);
    }
}
