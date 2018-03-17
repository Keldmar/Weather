package com.yahnenko.app.weather;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yahnenko.app.weather.adapters.WeatherForOneDay;
import com.yahnenko.app.weather.response.forecast.Forecast;
import com.yahnenko.app.weather.response.forecast.WeatherForThreeHours;
import com.yahnenko.app.weather.response.weather.GetWeather;
import com.yahnenko.app.weather.util.WeatherConverter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.yahnenko.app.weather.util.BackgroundUtil.getBackgroundByDate;

public class InformationActivity extends AppCompatActivity {

    public static final int FORTH_DAY = 4;
    public static final int WEATHER_FORTH_DAY = 3;
    public static final int SECOND_DAY = 1;
    public static final float KELVIN_EQUIVALENT = 273.15f;
    public static final int THREE_DAY = 2;
    private float maxTemp;
    private float minTemp;
    private LinearLayout rootLayout;
    private int resurseImage;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        ImageView image = (ImageView) findViewById(R.id.image);
        Button button2 = (Button) findViewById(R.id.normal_show);

        TextView mainTemperature = (TextView) findViewById(R.id.temperatura);
        TextView description = (TextView) findViewById(R.id.description);
        TextView textHumidity = (TextView) findViewById(R.id.humidity);
        TextView textPressure = (TextView) findViewById(R.id.pressure);
        TextView textspeed = (TextView) findViewById(R.id.speed);

        TextView sunrise = (TextView) findViewById(R.id.sunrise);
        TextView sunset = (TextView) findViewById(R.id.sunset);

        final TextView tempSecondDay = (TextView) findViewById(R.id.temp_second_day);
        final TextView tempThreeDay = (TextView) findViewById(R.id.temp_three_day);
        final TextView tempForthDay = (TextView) findViewById(R.id.temp_forth_day);

        final TextView dataSecondDay = (TextView) findViewById(R.id.data_second_day);
        final TextView dataThreeDay = (TextView) findViewById(R.id.data_three_day);
        final TextView dataForthDay = (TextView) findViewById(R.id.data_forth_day);

        final ImageView imageSecondDay = (ImageView) findViewById(R.id.image__second_day);
        final ImageView imageThreeDay = (ImageView) findViewById(R.id.image_three_day);
        final ImageView imageForthDay = (ImageView) findViewById(R.id.image_forth_day);

        rootLayout = (LinearLayout) findViewById(R.id.rootLayout);

        String language = null;
        language = Locale.getDefault().getLanguage();

        final GetWeather weather = (GetWeather) getIntent().getExtras().getSerializable("temp");

        description.setText(weather.weather.get(0).description);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(weather.name + ", " + weather.sys.country);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mainTemperature.setText(String.format("%.0f", weather.main.temp - KELVIN_EQUIVALENT) + "°");

        textHumidity.setText(String.format("%.0f", weather.main.humidity) + "%");
        textspeed.setText(String.format("%.0f", weather.wind.speed) + "m/s");
        textPressure.setText(String.format("%.0f", weather.main.pressure) + "hpa");

        Date dateSunrise = new Date((long)weather.sys.sunrise * 1000);
        Date dateSunset = new Date((long)weather.sys.sunset * 1000);
        SimpleDateFormat sdfSun = new SimpleDateFormat("HH:mm:ss");
//        sdfSun.setTimeZone(TimeZone.getDefault());
        sunrise.setText(sdfSun.format(dateSunrise));
        sunset.setText(sdfSun.format(dateSunset));

        WeatherApplication.getApiManager().forecast(weather.name).enqueue(new Callback<Forecast>() {
            @Override
            public void onResponse(Call<Forecast> call, Response<Forecast> response) {
                Forecast forecast = response.body();
                List<WeatherForThreeHours> listForThreeHours = forecast.list;
                List<WeatherForOneDay> onedayList = WeatherConverter.convertWeather(listForThreeHours);

                resurseImage = getBackgroundByDate(listForThreeHours.get(0).dt);
                rootLayout.setBackgroundResource(resurseImage);

                for (int i = SECOND_DAY; i < FORTH_DAY; i++) {
                    WeatherForOneDay weatherForOneDay = onedayList.get(i);
                    WeatherForThreeHours threehoursMinMax = weatherForOneDay.weatherForThreeHoursList.get(0);

                    String image = getImageDay(weatherForOneDay);

                    Date date = new Date(threehoursMinMax.dt * 1000);
                    SimpleDateFormat sdf = new SimpleDateFormat("EEE, d - MMMM");
                    maxTemp = threehoursMinMax.main.temp;
                    minTemp = threehoursMinMax.main.temp;
                    for (int j = 0; j < weatherForOneDay.weatherForThreeHoursList.size(); j++) {
                        WeatherForThreeHours threehours = weatherForOneDay.weatherForThreeHoursList.get(j);
                        if (threehours.main.temp > maxTemp) {
                            maxTemp = threehours.main.temp;
                        }
                        if (threehours.main.temp < minTemp) {
                            minTemp = threehours.main.temp;
                        }
                    }
                    if (i == SECOND_DAY) {
                        Uri uri = Uri.parse("http://openweathermap.org/img/w/" + image + ".png");
                        Glide
                                .with(InformationActivity.this)
                                .load(uri)
                                .into(imageSecondDay);
                        dataSecondDay.setText(sdf.format(date));
                        tempSecondDay.setText((String.format("%.0f",minTemp - KELVIN_EQUIVALENT)) + "° - " + String.format("%.0f",maxTemp - KELVIN_EQUIVALENT)+"°");
                    } else {
                        if (i == THREE_DAY) {
                            Uri uri = Uri.parse("http://openweathermap.org/img/w/" + image + ".png");
                            Glide
                                    .with(InformationActivity.this)
                                    .load(uri)
                                    .into(imageThreeDay);
                            dataThreeDay.setText(sdf.format(date));
                            tempThreeDay.setText((String.format("%.0f",minTemp - KELVIN_EQUIVALENT)) + "° - " + String.format("%.0f",maxTemp - KELVIN_EQUIVALENT)+"°");
                        } else {
                            if (i == WEATHER_FORTH_DAY) {
                                Uri uri = Uri.parse("http://openweathermap.org/img/w/" + image + ".png");
                                Glide
                                        .with(InformationActivity.this)
                                        .load(uri)
                                        .into(imageForthDay);
                                dataForthDay.setText(sdf.format(date));
                                tempForthDay.setText((String.format("%.0f",minTemp - KELVIN_EQUIVALENT)) + "° - " + String.format("%.0f",maxTemp - KELVIN_EQUIVALENT)+"°");
                            }
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<Forecast> call, Throwable t) {

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InformationActivity.this, NormalForecastActivity.class);
                intent.putExtra("name", weather.name);
                intent.putExtra("background", resurseImage);
                startActivity(intent);
            }
        });

        WeatherApplication.getApiManager();
        Uri uri = Uri.parse("http://openweathermap.org/img/w/" + weather.weather.get(0).icon + ".png");

        Glide
                .with(this)
                .load(uri)
                .into(image);

    }

    private String getImageDay(WeatherForOneDay weatherForOneDay) {
        int startvalueimage = 1;
        String image = weatherForOneDay.weatherForThreeHoursList.get(0).weather.get(0).icon;
        HashMap<String, Integer> hashMapImagValue = new HashMap<>();
        for (int i = 0; i < weatherForOneDay.weatherForThreeHoursList.size(); i++) {
            if (hashMapImagValue.containsKey(weatherForOneDay.weatherForThreeHoursList.get(i).weather.get(0).icon)) {
                int tmpValue = hashMapImagValue.get((weatherForOneDay.weatherForThreeHoursList.get(i).weather.get(0).icon));
                hashMapImagValue.put(weatherForOneDay.weatherForThreeHoursList.get(i).weather.get(0).icon, ++tmpValue);
            } else {
                hashMapImagValue.put(weatherForOneDay.weatherForThreeHoursList.get(i).weather.get(0).icon, startvalueimage);
            }
        }
        int maxValue = 1;
        for (Map.Entry<String, Integer> entry : hashMapImagValue.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                image = entry.getKey();
            }
        }
        return image;
    }

}