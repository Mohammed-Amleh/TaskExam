package com.example.taskexam.Rep;

import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.taskexam.Model.Country;
import com.example.taskexam.database.CountryApi;
import com.example.taskexam.database.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Rep {


    private MutableLiveData<List<Country>> getAllCountries = new MutableLiveData<>();




    public LiveData<List<Country>> getAlllCountries(){
        apiCall();
        return getAllCountries;

    }


    public void apiCall(){

        CountryApi countryApi = RetrofitInstance.getRetrofitInstance().create(CountryApi.class);
        Call<List<Country>> call = countryApi.getCountries();
        call.enqueue(new Callback<List<Country>>() {
            @Override
            public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {

                if (response.isSuccessful()){

                    getAllCountries.postValue(response.body());

                }else

                    Log.d("Rpoooo","Eroor");
            }

            @Override
            public void onFailure(Call<List<Country>> call, Throwable t) {

            }
        });


    }



}
