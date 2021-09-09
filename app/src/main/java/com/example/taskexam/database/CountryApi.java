package com.example.taskexam.database;

import com.example.taskexam.Model.Country;
import com.example.taskexam.Model.Weather;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface CountryApi {

    //    //https://api.openweathermap.org/data/2.5/
    //    forecast/daily?q=Europe&cnt=4&appid=1867722b6af87e1d0388e10c5a94be34

    @GET("all")
    Call<List<Country>> getCountries();




    
}
