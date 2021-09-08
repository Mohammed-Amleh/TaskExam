package com.example.taskexam;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.taskexam.Model.Country;
import com.example.taskexam.ViewModel.CountryViewModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailFragment extends Fragment {


    private NavController navController;
    private CountryViewModel sharedViewModel;

    private TextView tv_Name,tv_region_name,tv_capital_name,tv_population_name;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetailFragment newInstance(String param1, String param2) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        sharedViewModel = new ViewModelProvider(requireActivity()).get(CountryViewModel.class);


        tv_Name = view.findViewById(R.id.tv_Name);
        tv_capital_name = view.findViewById(R.id.tv_capital_name);
        tv_region_name = view.findViewById(R.id.tv_region_name);
        tv_population_name = view.findViewById(R.id.tv_population_name);


        sharedViewModel.getCountry().observe(getViewLifecycleOwner(), new Observer<Country>() {
            @Override
            public void onChanged(Country country) {
                updateUI(country);
            }
        });
    }

    private void updateUI(Country country) {
        tv_Name.setText(country.getName());
        tv_capital_name.setText(country.getCapital());
        tv_region_name.setText(country.getRegion());
        tv_population_name.setText(country.getPopulation());
    }
}