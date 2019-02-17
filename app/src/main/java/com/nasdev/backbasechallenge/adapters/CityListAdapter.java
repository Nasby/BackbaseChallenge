package com.nasdev.backbasechallenge.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nasdev.backbasechallenge.R;
import com.nasdev.backbasechallenge.models.City;

import java.util.ArrayList;
import java.util.Locale;

public class CityListAdapter extends RecyclerView.Adapter<CityListAdapter.MyViewHolder> {
    private String[] mDataSet;
    private static ArrayList<City> mCities;
    private Context mContext;

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView textView;
        private Context mContext;
        private MyViewHolder(TextView v, Context myContext){
            super(v);
            textView = v;
            mContext = myContext;
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            TextView text = (TextView)view;
            String str = text.getText().toString();

            //Find cities lat/long, open URI to google maps
            for (City city : mCities){
                if (str.equals(city.toString())){
                    String uri = String.format(Locale.ENGLISH, "geo:%f,%f", city.getCoord().getLat(), city.getCoord().getLon());
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                    mContext.startActivity(intent);
                }
            }
        }
    }

    public CityListAdapter(String[] myDataSet, ArrayList<City> myCities, Context myContext){
        mDataSet = myDataSet;
        mCities = myCities;
        mContext = myContext;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        TextView v = (TextView) LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.city_view_cell, viewGroup, false);

        return new MyViewHolder(v, mContext);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.textView.setText(mDataSet[i]);
    }


    @Override
    public int getItemCount() {
        return mDataSet.length;
    }
}
