package com.example.taskexam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.taskexam.Model.Country;
import com.example.taskexam.ViewModel.CountryViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Activity2 extends AppCompatActivity {


    private BottomNavigationView nav_bottom;

    private CountryViewModel viewModel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        nav_bottom = findViewById(R.id.nav_bottom);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewModel = new ViewModelProvider(this).get(CountryViewModel.class);

       Intent i =  getIntent();
       Country country = (Country) i.getSerializableExtra("country");
       viewModel.seCountry(country);




        //Default Fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new DetailFragment())
                .commit();

        nav_bottom.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                Fragment fragment = null;
                switch (item.getItemId()){
                    case R.id.nav_detail:
                        fragment = new DetailFragment();

                        break;
                    case R.id.nav_weather:
                        fragment = new MoreDetailFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment)
                        .commit();
                return true;
            }
        });







    }
}