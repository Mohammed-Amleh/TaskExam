package com.example.taskexam.database;

import com.example.taskexam.Model.Weather;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApi {

    @GET("daily")
    Call<List<Weather>> getWeatherStates(@Query("q") String cityname,
                                         @Query("cnt") int cnt,
                                         @Query("appid") String appkey);


}
