package com.nasdev.backbasechallenge.models;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class City implements Comparable<City>{
    @SerializedName("_id") private int id;
    @SerializedName("country") private String country;
    @SerializedName("name") private String name;
    @SerializedName("coord") private Coordinate coord;

    @Override
    public String toString() {
        return name + ", " + country;
    }

    public Coordinate getCoord() {
        return coord;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public int compareTo(@NonNull City city) {
        if (this.name.equals(city.name)){
            return this.country.compareTo(city.getCountry());
        }else{
            return this.name.compareTo(city.getName());
        }
    }
}
