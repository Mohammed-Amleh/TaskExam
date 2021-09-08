package com.example.taskexam.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.taskexam.Model.Country;
import com.example.taskexam.Rep.Rep;

import java.util.List;

public class CountryViewModel extends ViewModel {

    private static final String TAG = "SharedViewModel";
    private MutableLiveData<List<Country>> mutableCountries = new MutableLiveData<>();
    private MutableLiveData<Country>  mutableCountry = new MutableLiveData<>();

    Rep rep = new Rep();

   public LiveData<List<Country>> getAllCounries(){

        return rep.getAlllCountries();
    }

    public LiveData<Country> getCountry(){
        return mutableCountry;
    }

    public void seCountry(int pos){
       if (mutableCountries.getValue() != null) {
           Country country = mutableCountries.getValue().get(pos);
           mutableCountry.setValue(country);
       }
    }






}
