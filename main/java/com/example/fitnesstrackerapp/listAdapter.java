package com.example.fitnesstrackerapp;

import android.annotation.SuppressLint;
import android.app.Activity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class listAdapter extends ArrayAdapter<Food> {

    public static String calories;

    Button btn;

    public listAdapter(Context context, ArrayList<Food> foods) {
        super(context, 0, foods);
    }

    public View getView(int position, View view, ViewGroup parent) {
        Food food = getItem(position);

        if(view == null){
            view = LayoutInflater.from(getContext()).inflate(R.layout.listitem, parent, false);
        }

        TextView titleText = (TextView) view.findViewById(R.id.title);
        TextView subtitleText = (TextView) view.findViewById(R.id.subtitle);

        titleText.setText(food.name);
        subtitleText.setText(food.calories);

        calories = food.calories;

        return view;
    };


}  