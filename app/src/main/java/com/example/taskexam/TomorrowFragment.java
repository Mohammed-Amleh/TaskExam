package com.example.taskexam;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.taskexam.Model.Weather;
import com.example.taskexam.ViewModel.CountryViewModel;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class TomorrowFragment extends Fragment {

    CountryViewModel weatherViewModel;

    private TextView tv_date,tv_temp,tv_pressure,tv_humidity;
    private ImageView iv_sun_photo;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tomorrow, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View v, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(v, savedInstanceState);
        tv_date = v.findViewById(R.id.tv_date);
        tv_temp = v.findViewById(R.id.tv_temp);
        tv_pressure = v.findViewById(R.id.tv_pressure);
        tv_humidity = v.findViewById(R.id.tv_humidity);

        iv_sun_photo = v.findViewById(R.id.iv_country_photo);


        weatherViewModel = new ViewModelProvider(requireActivity()).get(CountryViewModel.class);
        weatherViewModel.getMutableWeatherStates().observe(getViewLifecycleOwner(), new Observer<List<Weather>>() {
            @Override
            public void onChanged(List<Weather> weathers) {
                updateUI(weathers);
            }
        });

    }

    @SuppressLint("SetTextI18n")
    private void updateUI(List<Weather> weathers) {

        Date date = new Timestamp(Long.parseLong(weathers.get(0).getList().get(1).getDt()+""));
        tv_date.setText(date.toString());
        tv_temp.setText((weathers.get(0).getList().get(1).getTemp().getMax())+""+(weathers.get(0).getList().get(1).getTemp().getMin()));
        tv_pressure.setText(weathers.get(0).getList().get(1).getPressure());
        tv_humidity.setText(weathers.get(0).getList().get(1).getHumidity());

//        iv_sun_photo
    }

}
