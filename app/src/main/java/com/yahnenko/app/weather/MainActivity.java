package com.yahnenko.app.weather;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.yahnenko.app.weather.response.weather.GetWeather;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    private EditText cityEditText;
    private Button button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        cityEditText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.batton);
        button.setOnClickListener(v -> getWeather());
        cityEditText.setText(WeatherApplication.getPreferencesManager().getCity());
    }

    private void getWeather() {
        String name;
        name = cityEditText.getText().toString();
        WeatherApplication.getPreferencesManager().setCity(name);

        WeatherApplication.getApiManager().getweather(name).enqueue(new Callback<GetWeather>() {
            @Override
            public void onResponse(Call<GetWeather> call, Response<GetWeather> response) {
                GetWeather weather = response.body();
                if (response.code() / 100 != 2) {
                    Toast.makeText(getApplicationContext(), R.string.city_not_exist, Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(MainActivity.this, InformationActivity.class);
                    intent.putExtra("temp", weather);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<GetWeather> call, Throwable t) {
                Toast.makeText(getApplicationContext(), R.string.no_response_from_server, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
