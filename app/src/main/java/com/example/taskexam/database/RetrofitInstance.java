package com.example.taskexam.database;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    public static String BASE_URL = "https://restcountries.eu/rest/v1/";
    public static String BASE_URL2 = "https://api.openweathermap.org/data/2.5/forecast/";

    private static Retrofit instance;
    private static Retrofit instance2;

    public static Retrofit getRetrofitInstance(){
        if(instance == null){
            instance = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return instance;

    }
    public static Retrofit getRetrofitInstance2(){
        if(instance2 == null){
            instance2 = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL2)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return instance2;

    }

}
