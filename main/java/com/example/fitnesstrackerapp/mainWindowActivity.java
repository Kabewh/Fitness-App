package com.example.fitnesstrackerapp;


import static com.example.fitnesstrackerapp.detailsActivity.caloriesMenActivDeficitResult;
import static com.example.fitnesstrackerapp.detailsActivity.caloriesMenActivMentinereResult;
import static com.example.fitnesstrackerapp.detailsActivity.caloriesMenActivSurplusResult;
import static com.example.fitnesstrackerapp.detailsActivity.caloriesMenModeratDeficitResult;
import static com.example.fitnesstrackerapp.detailsActivity.caloriesMenModeratMentinereResult;
import static com.example.fitnesstrackerapp.detailsActivity.caloriesMenModeratSurplusResult;
import static com.example.fitnesstrackerapp.detailsActivity.caloriesMenSedentarDeficitResult;
import static com.example.fitnesstrackerapp.detailsActivity.caloriesMenSedentarMentinereResult;
import static com.example.fitnesstrackerapp.detailsActivity.caloriesMenSedentarSurplusResult;
import static com.example.fitnesstrackerapp.detailsActivity.caloriesWomenActivDeficitResult;
import static com.example.fitnesstrackerapp.detailsActivity.caloriesWomenActivMentinereResult;
import static com.example.fitnesstrackerapp.detailsActivity.caloriesWomenActivSurplusResult;
import static com.example.fitnesstrackerapp.detailsActivity.caloriesWomenModeratDeficitResult;
import static com.example.fitnesstrackerapp.detailsActivity.caloriesWomenModeratMentinereResult;
import static com.example.fitnesstrackerapp.detailsActivity.caloriesWomenModeratSurplusResult;
import static com.example.fitnesstrackerapp.detailsActivity.caloriesWomenSedentarDeficitResult;
import static com.example.fitnesstrackerapp.detailsActivity.caloriesWomenSedentarMentinereResult;
import static com.example.fitnesstrackerapp.detailsActivity.caloriesWomenSedentarSurplusResult;
import static com.example.fitnesstrackerapp.detailsActivity.femaleSelected;
import static com.example.fitnesstrackerapp.detailsActivity.lightlyActive;
import static com.example.fitnesstrackerapp.detailsActivity.maleSelected;
import static com.example.fitnesstrackerapp.detailsActivity.sedentary;
import static com.example.fitnesstrackerapp.detailsActivity.veryActive;
import static com.example.fitnesstrackerapp.detailsActivity.weight;
import static com.example.fitnesstrackerapp.goalsActivity.gainWeightClicked;
import static com.example.fitnesstrackerapp.goalsActivity.loseWeightClicked;
import static com.example.fitnesstrackerapp.goalsActivity.maintainWeightClicked;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class mainWindowActivity extends AppCompatActivity {

    TextView calorieTotal;
    TextView currentWeight;
    TextView caloriesConsumed;
    TextView caloriesLeft;

    Button meIconBtn;
    Button homeIconBtn;
    Button diaryIconBtn;
    Button weightIconBtn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_mainwindow);

        calorieTotal = (TextView) findViewById(R.id.calorieTotal1);
        currentWeight = (TextView) findViewById(R.id.currentWeightTxtView);
        caloriesConsumed = (TextView) findViewById(R.id.caloriesConsumed2);
        caloriesLeft = (TextView) findViewById(R.id.caloriesLeft2);

        meIconBtn = (Button) findViewById(R.id.meIconBtn);
        homeIconBtn = (Button) findViewById(R.id.homeIconBtn);
        diaryIconBtn = (Button) findViewById(R.id.diaryIconBtn);
        weightIconBtn = (Button) findViewById(R.id.weightIconBtn);


        meIconBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mainWindowActivity.this, meActivity.class);
                startActivity(intent);
            }
        });

        homeIconBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mainWindowActivity.this, mainWindowActivity.class);
                startActivity(intent);
            }
        });

        diaryIconBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mainWindowActivity.this, diaryActivity.class);
                startActivity(intent);
            }
        });

        weightIconBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mainWindowActivity.this, weightActivity.class);
                startActivity(intent);
            }
        });


        setCurrentWeight();
        setMaleCalories();
        setFemaleCalories();

        if(diaryActivity.doneButtonClicked){
            caloriesConsumed.setText(String.valueOf(diaryActivity.sumCalories));
            caloriesLeft.setText(String.valueOf(diaryActivity.caloriesLeftDouble));
        }
    }

    void setMaleCalories(){

        //////MALE MAINTAIN WEIGHT
        if(maintainWeightClicked && sedentary && maleSelected){
            calorieTotal.setText(caloriesMenSedentarMentinereResult);
        }
        else if(maintainWeightClicked && lightlyActive && maleSelected){
            calorieTotal.setText(caloriesMenModeratMentinereResult);
        }
        else if(maintainWeightClicked && veryActive && maleSelected) {
            calorieTotal.setText(caloriesMenActivMentinereResult);
        }

        /////MALE LOSE WEIGHT
        if(loseWeightClicked && sedentary && maleSelected){
            calorieTotal.setText(caloriesMenSedentarDeficitResult);
        }
        else if(loseWeightClicked && lightlyActive && maleSelected){
            calorieTotal.setText(caloriesMenModeratDeficitResult);
        }
        else if(loseWeightClicked && veryActive && maleSelected) {
            calorieTotal.setText(caloriesMenActivDeficitResult);
        }

        /////MALE GAIN WEIGHT
        if(gainWeightClicked && sedentary && maleSelected){
            calorieTotal.setText(caloriesMenSedentarSurplusResult);
        }
        else if(gainWeightClicked && lightlyActive && maleSelected){
            calorieTotal.setText(caloriesMenModeratSurplusResult);
        }
        else if(gainWeightClicked && veryActive && maleSelected) {
            calorieTotal.setText(caloriesMenActivSurplusResult);
        }
    }

    void setFemaleCalories(){

        //////FEMALE MAINTAIN WEIGHT
        if(maintainWeightClicked && sedentary && femaleSelected){
            calorieTotal.setText(caloriesWomenSedentarMentinereResult);
        }
        else if(maintainWeightClicked && lightlyActive && femaleSelected){
            calorieTotal.setText(caloriesWomenModeratMentinereResult);
        }
        else if(maintainWeightClicked && veryActive && femaleSelected) {
            calorieTotal.setText(caloriesWomenActivMentinereResult);
        }

        /////FEMALE LOSE WEIGHT
        if(loseWeightClicked && sedentary && femaleSelected){
            calorieTotal.setText(caloriesWomenSedentarDeficitResult);
        }
        else if(loseWeightClicked && lightlyActive && femaleSelected){
            calorieTotal.setText(caloriesWomenModeratDeficitResult);
        }
        else if(loseWeightClicked && veryActive && femaleSelected) {
            calorieTotal.setText(caloriesWomenActivDeficitResult);
        }

        /////FEMALE GAIN WEIGHT
        if(gainWeightClicked && sedentary && femaleSelected){
            calorieTotal.setText(caloriesWomenSedentarSurplusResult);
        }
        else if(gainWeightClicked && lightlyActive && femaleSelected){
            calorieTotal.setText(caloriesWomenModeratSurplusResult);
        }
        else if(gainWeightClicked && veryActive && femaleSelected) {
            calorieTotal.setText(caloriesWomenActivSurplusResult);
        }
    }
    void setCurrentWeight(){
        String currentWeightString = currentWeight.getText().toString();
        currentWeightString = weight;
        if (weightActivity.updateWeightClicked){
            Toast.makeText(mainWindowActivity.this, weightActivity.editTextCurrentWeightString, Toast.LENGTH_SHORT).show();
            currentWeight.setText(weightActivity.editTextCurrentWeightString);
        } else {
            currentWeight.setText(currentWeightString);
        }
    }
}
