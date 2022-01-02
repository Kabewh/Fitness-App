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
import static com.example.fitnesstrackerapp.goalsActivity.gainWeightClicked;
import static com.example.fitnesstrackerapp.goalsActivity.loseWeightClicked;
import static com.example.fitnesstrackerapp.goalsActivity.maintainWeightClicked;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class diaryActivity extends AppCompatActivity {

    Button breakfastAddFoodBtn;
    Button lunchAddFoodBtn;
    Button dinnerAddFoodBtn;

    Button diaryDoneBtn;

    TextView caloriesConsumed;
    TextView caloriesTotal1;
    TextView caloriesLeft;

    TextView txtBreakfastCalories;
    TextView txtLunchCalories;
    TextView txtDinnerCalories;

    public static boolean doneButtonClicked;
    public static String caloriesConsumedString;
    public static double caloriesLeftDouble;
    public static int sumCalories;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_diary);

        caloriesTotal1 = (TextView) findViewById(R.id.calorieTotal1);
        caloriesConsumed = (TextView) findViewById(R.id.caloriesConsumed2);
        caloriesLeft = (TextView) findViewById(R.id.caloriesLeft2);

        txtBreakfastCalories = (TextView) findViewById(R.id.txtBreakfastCalories);
        txtLunchCalories = (TextView) findViewById(R.id.txtLunchCalories);
        txtDinnerCalories = (TextView) findViewById(R.id.txtDinnerCalories);

        breakfastAddFoodBtn = (Button) findViewById(R.id.breakfastAddFoodBtn);
        lunchAddFoodBtn = (Button) findViewById(R.id.lunchAddFoodBtn);
        dinnerAddFoodBtn = (Button) findViewById(R.id.dinnerAddFoodBtn);

        diaryDoneBtn = (Button) findViewById(R.id.diaryDoneBtn);

        caloriesConsumedString = caloriesConsumed.getText().toString();

        breakfastAddFoodBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(diaryActivity.this, searchFoodActivity.class);
                startActivity(intent);
            }
        });

        lunchAddFoodBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(diaryActivity.this, searchFoodActivity.class);
                startActivity(intent);
            }
        });

        dinnerAddFoodBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(diaryActivity.this, searchFoodActivity.class);
                startActivity(intent);
            }
        });
        setMaleCalories();
        setFemaleCalories();
        setCaloriesLeft();
        setConsumedCalories();

        diaryDoneBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(diaryActivity.this, mainWindowActivity.class);
                startActivity(intent);
                doneButtonClicked = true;
            }
        });



    }

    void setCaloriesLeft(){
        String caloriesTotalString = caloriesTotal1.getText().toString();
        double caloriesTotalDouble = Double.parseDouble(caloriesTotalString);
        caloriesLeftDouble = Double.parseDouble(String.valueOf(caloriesTotalDouble - sumCalories));

        caloriesLeft.setText(String.valueOf(caloriesLeftDouble));
    }

    void setConsumedCalories(){
        Intent intent = getIntent();
        int calories = intent.getIntExtra("calories", 0);
        sumCalories = sumCalories + calories;
        caloriesConsumed.setText(String.valueOf(sumCalories));
    }

//    void setConsumedCaloriesBreakfast(){
//        Intent intent = getIntent();
//        int calories = intent.getIntExtra("calories", 0);
//        sumCalories = sumCalories + calories;
//        caloriesConsumed.setText(String.valueOf(sumCalories));
//    }
//
//    void setConsumedCaloriesLunch(){
//        Intent intent = getIntent();
//        int calories = intent.getIntExtra("calories", 0);
//        sumCalories = sumCalories + calories;
//        caloriesConsumed.setText(String.valueOf(sumCalories));
//    }
//
//    void setConsumedCaloriesDinner(){
//        Intent intent = getIntent();
//        int calories = intent.getIntExtra("calories", 0);
//        sumCalories = sumCalories + calories;
//        caloriesConsumed.setText(String.valueOf(sumCalories));
//    }

    void setMaleCalories(){
        //////MALE MAINTAIN WEIGHT
        if(maintainWeightClicked && sedentary && maleSelected){
            caloriesTotal1.setText(caloriesMenSedentarMentinereResult);
        }
        else if(maintainWeightClicked && lightlyActive && maleSelected){
            caloriesTotal1.setText(caloriesMenModeratMentinereResult);
        }
        else if(maintainWeightClicked && veryActive && maleSelected) {
            caloriesTotal1.setText(caloriesMenActivMentinereResult);
        }

        /////MALE LOSE WEIGHT
        if(loseWeightClicked && sedentary && maleSelected){
            caloriesTotal1.setText(caloriesMenSedentarDeficitResult);
        }
        else if(loseWeightClicked && lightlyActive && maleSelected){
            caloriesTotal1.setText(caloriesMenModeratDeficitResult);
        }
        else if(loseWeightClicked && veryActive && maleSelected) {
            caloriesTotal1.setText(caloriesMenActivDeficitResult);
        }

        /////MALE GAIN WEIGHT
        if(gainWeightClicked && sedentary && maleSelected){
            caloriesTotal1.setText(caloriesMenSedentarSurplusResult);
        }
        else if(gainWeightClicked && lightlyActive && maleSelected){
            caloriesTotal1.setText(caloriesMenModeratSurplusResult);
        }
        else if(gainWeightClicked && veryActive && maleSelected) {
            caloriesTotal1.setText(caloriesMenActivSurplusResult);
        }
    }

    void setFemaleCalories(){

        //////FEMALE MAINTAIN WEIGHT
        if(maintainWeightClicked && sedentary && femaleSelected){
            caloriesTotal1.setText(caloriesWomenSedentarMentinereResult);
        }
        else if(maintainWeightClicked && lightlyActive && femaleSelected){
            caloriesTotal1.setText(caloriesWomenModeratMentinereResult);
        }
        else if(maintainWeightClicked && veryActive && femaleSelected) {
            caloriesTotal1.setText(caloriesWomenActivMentinereResult);
        }

        /////FEMALE LOSE WEIGHT
        if(loseWeightClicked && sedentary && femaleSelected){
            caloriesTotal1.setText(caloriesWomenSedentarDeficitResult);
        }
        else if(loseWeightClicked && lightlyActive && femaleSelected){
            caloriesTotal1.setText(caloriesWomenModeratDeficitResult);
        }
        else if(loseWeightClicked && veryActive && femaleSelected) {
            caloriesTotal1.setText(caloriesWomenActivDeficitResult);
        }

        /////FEMALE GAIN WEIGHT
        if(gainWeightClicked && sedentary && femaleSelected){
            caloriesTotal1.setText(caloriesWomenSedentarSurplusResult);
        }
        else if(gainWeightClicked && lightlyActive && femaleSelected){
            caloriesTotal1.setText(caloriesWomenModeratSurplusResult);
        }
        else if(gainWeightClicked && veryActive && femaleSelected) {
            caloriesTotal1.setText(caloriesWomenActivSurplusResult);
        }
    }

}
