package com.example.yazon.weather.Adapters;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yazon.weather.R;

public class WeatherPagerFragment extends Fragment {
    private RecyclerView recyclerview;

    public static WeatherPagerFragment getInstance(WeatherForOneDay weatherForOneDay) {
        WeatherPagerFragment weatherPagerFragment = new WeatherPagerFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("key", weatherForOneDay);
        weatherPagerFragment.setArguments(bundle);
        return weatherPagerFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View viewHierarchy = inflater.inflate(R.layout.page, container, false);
        recyclerview = (RecyclerView)viewHierarchy.findViewById(R.id.recycler_view);
        return viewHierarchy;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            WeatherForOneDay weatherForOneDay = (WeatherForOneDay) bundle.getSerializable("key");
            NormalRecyclerViewAdapter normalRecyclerViewAdapter = new NormalRecyclerViewAdapter(weatherForOneDay.weatherForThreeHoursList);
            recyclerview.setAdapter(normalRecyclerViewAdapter);
//            textView.setText(weatherForOneDay.toString());
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
