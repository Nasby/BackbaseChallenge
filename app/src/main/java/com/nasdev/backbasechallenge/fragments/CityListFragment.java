package com.nasdev.backbasechallenge.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.nasdev.backbasechallenge.R;
import com.nasdev.backbasechallenge.adapters.CityListAdapter;
import com.nasdev.backbasechallenge.datastructures.Trie;
import com.nasdev.backbasechallenge.models.City;
import com.nasdev.backbasechallenge.util.CityHelper;

import java.util.ArrayList;
import java.util.Collections;

public class CityListFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private TextView searchView;
    private ArrayList<City> cities;
    private String[] originalList;
    private Trie trie;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_city_list, container, false);

        //Initialize views
        searchView = view.findViewById(R.id.searchView);
        recyclerView = view.findViewById(R.id.cityList);
        //Speeds up recycler view since we don't have variable sizes
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        //Get initial city list
        cities = CityHelper.getCityList(getContext());
        Collections.sort(cities);
        trie = new Trie();
        originalList = new String[cities.size()];

        //Populate both our Trie for searching and our recycler view
        for (int i = 0; i < cities.size(); i++){
            originalList[i] = cities.get(i).toString();
            trie.insert(cities.get(i).toString());
        }
        //Initiate our list of cities with data
        mAdapter = new CityListAdapter(originalList, cities, getContext());
        recyclerView.setAdapter(mAdapter);

        searchView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                //Reset to original list if search string is empty
                if (editable.length() == 0){
                    mAdapter = new CityListAdapter(originalList, cities, getContext());
                    recyclerView.setAdapter(mAdapter);
                }//Search our list using our Trie, update list based on matches
                else{
                    ArrayList<String> searchList = trie.convertNodeToList(editable.toString(), trie.find(editable.toString()));
                    Collections.sort(searchList);
                    String[] searchArray = searchList.toArray(new String[searchList.size()]);
                    mAdapter = new CityListAdapter(searchArray, cities, getContext());
                    recyclerView.setAdapter(mAdapter);
                }

            }
        });

        return view;
    }
}
