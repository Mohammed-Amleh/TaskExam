package com.example.taskexam.database;

import com.example.taskexam.Model.Country;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface CountryApi {

    @GET("all")
    Call<List<Country>> getCountries();


    
}
