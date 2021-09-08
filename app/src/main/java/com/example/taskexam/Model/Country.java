package com.example.taskexam.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Country implements Serializable {


    @SerializedName("alpha2Code")
    private String id;
    private String name;
    private String region;
    private String population;
    private String imageFlag;
    private String capital;


    public Country(String name, String region, String population) {
        this.name = name;
        this.region = region;
        this.population = population;
    }

    public String getImageFlag() {
        return imageFlag;
    }

    public void setImageFlag(String imageFlag) {
        this.imageFlag = imageFlag;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }


    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }


}
