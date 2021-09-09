package com.example.taskexam.Rep;

import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.taskexam.Model.Country;
import com.example.taskexam.Model.Weather;
import com.example.taskexam.database.CountryApi;
import com.example.taskexam.database.RetrofitInstance;
import com.example.taskexam.database.WeatherApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Rep {


    private MutableLiveData<List<Country>> getAllCountries = new MutableLiveData<>();
    private MutableLiveData<List<Weather>> getAllWeatherStates = new MutableLiveData<>();





    public LiveData<List<Country>> getAlllCountries(){
        apiCallForCountries();
        return getAllCountries;

    }

    public LiveData<List<Weather>> getAlllWeatherStates(String name){
        apiCallForWeather(name);
        return getAllWeatherStates;

    }


    public void apiCallForCountries(){

        CountryApi countryApi = RetrofitInstance.getRetrofitInstance().create(CountryApi.class);
        Call<List<Country>> call = countryApi.getCountries();
        call.enqueue(new Callback<List<Country>>() {
            @Override
            public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {

                if (response.isSuccessful()){
                    getAllCountries.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Country>> call, Throwable t) {

            }
        });


    }

    public void apiCallForWeather(String name ){
        WeatherApi weatherApi = RetrofitInstance.getRetrofitInstance2().create(WeatherApi.class);
        Call<List<Weather>> call = weatherApi.getWeatherStates(name,2,"1867722b6af87e1d0388e10c5a94be34");
        call.enqueue(new Callback<List<Weather>>() {
            @Override
            public void onResponse(Call<List<Weather>> call, Response<List<Weather>> response) {

                if (response.isSuccessful()){
                    getAllWeatherStates.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Weather>> call, Throwable t) {

            }
        });





    }




}
