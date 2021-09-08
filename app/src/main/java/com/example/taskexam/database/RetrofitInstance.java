package com.example.taskexam.database;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    public static String BASE_URL = "https://restcountries.eu/rest/v1/";
    private static Retrofit instance;

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

}
