package com.example.yazon.weather;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yazon.weather.responseWeather.GetWeather;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    private EditText text;
    private Button button;
    private Spinner spiner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        text = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.batton);
        spiner = (Spinner) findViewById(R.id.spiner);
        spiner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView view1 = (TextView) view;
                text.setText(view1.getText());
                view1.setText(null);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
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

        WeatherApplication.getApiManager().getweather(name).enqueue(new Callback<GetWeather>() {
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
