package com.nasdev.backbasechallenge.models;
import com.google.gson.annotations.SerializedName;

public class Coordinate {
    @SerializedName("lat") private Double lat;
    @SerializedName("lon") private Double lon;

    public Double getLat() {
        return lat;
    }

    public Double getLon() {
        return lon;
    }
}
