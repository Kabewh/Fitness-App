package com.example.fitnesstrackerapp;

import static com.example.fitnesstrackerapp.diaryActivity.caloriesConsumedString;
import static com.example.fitnesstrackerapp.listAdapter.calories;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.apache.http.cookie.SM;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class searchFoodActivity extends AppCompatActivity{
    ListView listView;
    ArrayList<Food> foodList = new ArrayList<Food>();
    Button doneAddingFoodBtn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_searchfood);

        listView = (ListView) findViewById(R.id.foodListView);
        listAdapter adapter = new listAdapter(this, foodList);

        Food apple = new Food("Apple", "100");
        Food chickenBreast = new Food("Chicken Breast", "130");
        Food bread = new Food("Bread", "280 ");
        Food milk = new Food("Milk", "105.1");

        adapter.add(apple);
        adapter.add(chickenBreast);
        adapter.add(bread);
        adapter.add(milk);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Food foods = (Food) adapter.getItem(position);

                int foodsCalories = 0;
                try {
                    foodsCalories = Integer.parseInt(foods.calories);

                    Intent intent = new Intent(searchFoodActivity.this, diaryActivity.class);
                    intent.putExtra("calories", foodsCalories);

                    startActivity(intent);
                } catch(NumberFormatException e) {
                    System.out.println("parse value is not valid : " + e);
                }

//                    Intent intent = new Intent(searchFoodActivity.this, diaryActivity.class);
//                    intent.putExtra("calories", foodsCalories);
//
//                    startActivity(intent);
            }
        });

        doneAddingFoodBtn = (Button) findViewById(R.id.doneAddingFoodBtn);

        doneAddingFoodBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(searchFoodActivity.this, diaryActivity.class);
                startActivity(intent);
            }
        });
    }
}
