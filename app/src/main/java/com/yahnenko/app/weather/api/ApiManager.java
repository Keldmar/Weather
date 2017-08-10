package com.yahnenko.app.weather.api;

import com.yahnenko.app.weather.Openweathermap;
import com.yahnenko.app.weather.response.forecast.Forecast;
import com.yahnenko.app.weather.response.weather.GetWeather;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiManager {

    private final String URL = "http://api.openweathermap.org/data/2.5/";
    private final String KEY = "2b8b3f601dcf71d14beba9c2ce7b2cb5";
    String language = null;
    private Openweathermap service;

    public ApiManager() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        language = Locale.getDefault().getLanguage();
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();
                HttpUrl originalHttUrl = original.url();
                HttpUrl url = originalHttUrl.newBuilder()
                        .addQueryParameter("lang", language)
                        .addQueryParameter("APPID", KEY)
                        .build();
                Request.Builder requestBuilder = original.newBuilder()
                        .url(url);
                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        });


        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
                .baseUrl(URL)
                .client(httpClient.build())
                .build();

        service = retrofit.create(Openweathermap.class);
    }

    public Call<GetWeather> getweather(String cityname) {
        return service.getweather(cityname);
    }
    public Call<Forecast> forecast(String cityname) {
        return service.forecast(cityname);
    }

}
