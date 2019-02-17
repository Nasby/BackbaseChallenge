package com.nasdev.backbasechallenge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.nasdev.backbasechallenge.datastructures.Trie;
import com.nasdev.backbasechallenge.models.City;
import com.nasdev.backbasechallenge.util.CityHelper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
