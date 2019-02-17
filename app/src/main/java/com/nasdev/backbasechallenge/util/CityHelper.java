package com.nasdev.backbasechallenge.util;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.nasdev.backbasechallenge.R;
import com.nasdev.backbasechallenge.models.City;

import java.io.InputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;

public abstract class CityHelper {

    //Read our json array and create an ArrayList of cities
    public static ArrayList<City> getCityList(Context context){
        Gson gson = new GsonBuilder().create();
        String jsonString = JsonHelper.getJsonAsString(R.raw.cities, context);
        Type listType = new TypeToken<ArrayList<City>>(){}.getType();
        return gson.fromJson(jsonString, listType);
    }
}
