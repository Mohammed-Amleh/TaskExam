package com.example.taskexam;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.taskexam.Adpaters.SliderAdapter;
import com.example.taskexam.Model.Country;
import com.example.taskexam.Model.Weather;
import com.example.taskexam.ViewModel.CountryViewModel;
import com.example.taskexam.database.CountryApi;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

public class MoreDetailFragment extends Fragment {


    TabLayout tabLayout;
    ViewPager2 pager2;
    SliderAdapter sliderAdapter;
    CountryViewModel weatherViewModel;

    public MoreDetailFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //i think ViewModle must be here because i need 1 instance via 2 fragments
        CountryViewModel viewModel = new ViewModelProvider(requireActivity()).get(CountryViewModel.class);
        String name = viewModel.getCountryName();
        viewModel.getAllWeatherStates(name).observe(getViewLifecycleOwner(), new Observer<List<Weather>>() {
            @Override
            public void onChanged(List<Weather> weathers) {

                viewModel.setMutableWeatherStates(weathers);


            }
        });


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_more_detail, container, false);
        tabLayout = v.findViewById(R.id.tab_layout);
        pager2 = v.findViewById(R.id.view_pager);



        return  v ;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        String cityname="";


        sliderAdapter= new SliderAdapter(getParentFragmentManager(),getLifecycle());
        pager2.setAdapter(sliderAdapter);


       tabLayout.addTab(tabLayout.newTab().setText("Today"));

        tabLayout.addTab(tabLayout.newTab().setText("Tomorrow"));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager2.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {


            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        pager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });

    }
}