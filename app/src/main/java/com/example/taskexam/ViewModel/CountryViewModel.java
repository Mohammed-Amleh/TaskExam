package com.example.taskexam.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.taskexam.Model.Country;
import com.example.taskexam.Model.Weather;
import com.example.taskexam.Rep.Rep;

import java.util.List;

public class CountryViewModel extends ViewModel {

    private static final String TAG = "SharedViewModel";
    private MutableLiveData<List<Country>> mutableCountries = new MutableLiveData<>();
    private MutableLiveData<Country>  mutableCountry = new MutableLiveData<>();

    private MutableLiveData<List<Weather>> mutableWeatherStates = new MutableLiveData<>();
    private MutableLiveData<Weather>  mutableWeather = new MutableLiveData<>();



    Rep rep ;

    public CountryViewModel(){
        rep = new Rep();

    }

   public LiveData<List<Country>> getAllCounries(){

        return rep.getAlllCountries();
    }

    public LiveData<Country> getCountry(){
        return mutableCountry;
    }

    public void seCountry(Country country){
           mutableCountry.setValue(country);
       }
    public LiveData<List<Weather>> getAllWeatherStates(String name){

        return rep.getAlllWeatherStates(name);
    }

    public LiveData<Weather> getWeather(){
        return mutableWeather;
    }
    public String getCountryName(){
        return getCountry().getValue().getName();
    }

    public void setWeather(Weather weather){
        mutableWeather.setValue(weather);
    }

    public void setMutableWeatherStates(List<Weather> weatherStates){
        mutableWeatherStates.postValue(weatherStates);
    }

    public LiveData<List<Weather>> getMutableWeatherStates(){

        return mutableWeatherStates;
    }









}
