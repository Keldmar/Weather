package com.example.yazon.weather;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.yazon.weather.answer.GetWeather;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {
    private EditText text;
    private Button button;
    private Spinner spiner;

    private final String URL = "http://api.openweathermap.org/data/2.5/";
    private final String KEY = "2b8b3f601dcf71d14beba9c2ce7b2cb5";

    private Gson gson = new GsonBuilder().create();
    private Retrofit retrofit;
    Openweathermap service;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(URL)
                .client(httpClient.build())
                .build();

        service = retrofit.create(Openweathermap.class);

        setContentView(R.layout.activity_main);
        text = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.batton);
        spiner = (Spinner) findViewById(R.id.spiner);

    }

    public void onClickListener(View view) {

        String name;
        String selected = spiner.getSelectedItem().toString();
        if (selected.isEmpty()) {
            name = text.getText().toString();
        } else {
            name = selected;
            text.setText(selected);
        }
        Call<GetWeather> call = service.tmp(name, KEY);
        call.enqueue(new Callback<GetWeather>() {
            @Override
            public void onResponse(Call<GetWeather> call, Response<GetWeather> response) {
                GetWeather weather = response.body();
                if (response.code() / 100 != 2) {
                    Toast.makeText(getApplicationContext(), "Данного города не существует", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(MainActivity.this, InformationActivity.class);
                    intent.putExtra("temp", weather);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<GetWeather> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Нет ответа от сервера", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
