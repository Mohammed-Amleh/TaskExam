package com.example.taskexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.taskexam.Model.Country;

public class Activity2 extends AppCompatActivity {

    TextView tv_Name;
    TextView tv_region_name;
    TextView tv_population_name;
    TextView tv_capital_name;

    Button btn_Details;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        tv_Name= findViewById(R.id.tv_Name);
        tv_region_name = findViewById(R.id.tv_region_name);
        tv_population_name = findViewById(R.id.tv_population_name);
        tv_capital_name = findViewById(R.id.tv_capital_name);

        btn_Details = findViewById(R.id.btn_Details);


       Intent i =  getIntent();
      Country country = (Country) i.getSerializableExtra("country");
        Toast.makeText(this, "ssss", Toast.LENGTH_SHORT).show();


        tv_Name .setText(country.getName());
        tv_region_name.setText(country.getRegion());
        tv_population_name.setText(country.getPopulation());
        tv_capital_name.setText(country.getCapital());







    }
}