package com.example.fitnesstrackerapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class detailsActivity extends AppCompatActivity {

    Button submitButton;

    Spinner genderSpinner;
    Spinner activityLevelSpinner;

    EditText editTextAge;
    EditText editTextHeight;
    EditText editTextWeight;

    public static String age, height, weight, gender, activityLevel;

    public static boolean maleSelected = false;
    public static boolean femaleSelected= false;

    public static boolean sedentary = false;
    public static boolean lightlyActive = false;
    public static boolean veryActive = false;


    static double BMI = 0;
    static double caloriesMenSedentarMentinere = 0;
    double caloriesWomenSedentarMentinere = 0;

    static  double caloriesMenSedentarDeficit = 0;
    double caloriesWomenSedentarDeficit = 0;

    static double caloriesMenSedentarSurplus = 0;
    double caloriesWomenSedentarSurplus = 0;

    static double caloriesMenModeratMentinere = 0;
    double caloriesWomenModeratMentinere = 0;

    static double caloriesMenModeratDeficit = 0;
    double caloriesWomenModeratDeficit = 0;

    static double caloriesMenModeratSurplus = 0;
    double caloriesWomenModeratSurplus = 0;

    static double caloriesMenActivMentinere = 0;
    double caloriesWomenActivMentinere = 0;

    static double caloriesMenActivDeficit = 0;
    double caloriesWomenActivDeficit = 0;

    static double caloriesMenActivSurplus = 0;
    double caloriesWomenActivSurplus = 0;

    static double BMICalories = 0;
////////////////////////////////////////////////////


    public static String caloriesMenSedentarMentinereResult;
    public static String caloriesMenModeratMentinereResult;
    public static String caloriesMenActivMentinereResult;

    public static String caloriesMenSedentarDeficitResult;
    public static String caloriesMenModeratDeficitResult;
    public static String caloriesMenActivDeficitResult;

    public static String caloriesMenSedentarSurplusResult;
    public static String caloriesMenModeratSurplusResult;
    public static String caloriesMenActivSurplusResult;

///////////////////////////////////////////////////////////////////

    public static String caloriesWomenSedentarMentinereResult;
    public static String caloriesWomenModeratMentinereResult;
    public static String caloriesWomenActivMentinereResult;

    public static String caloriesWomenSedentarDeficitResult;
    public static String caloriesWomenModeratDeficitResult;
    public static String caloriesWomenActivDeficitResult;

    public static String caloriesWomenSedentarSurplusResult;
    public static String caloriesWomenModeratSurplusResult;
    public static String caloriesWomenActivSurplusResult;

    ///////////////////////////////////////////////////


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_details);

        submitButton = (Button) findViewById(R.id.updateWeightBtn);

        genderSpinner = (Spinner) findViewById(R.id.genderSpinner);
        activityLevelSpinner = (Spinner) findViewById(R.id.activityLevelSpinner);

        editTextAge = (EditText) findViewById(R.id.editTextAge);
        editTextHeight = (EditText) findViewById(R.id.editTextHeight);
        editTextWeight = (EditText) findViewById(R.id.editTextWeight);


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                age = editTextAge.getText().toString();
                weight = editTextWeight.getText().toString();
                height = editTextHeight.getText().toString();
                gender = genderSpinner.getSelectedItem().toString();
                activityLevel = activityLevelSpinner.getSelectedItem().toString();

                if (gender.equals("Male")){
                    maleSelected = true;
                }

                else if (gender.equals("Female")){
                    femaleSelected = true;
                }

                switch (activityLevel) {
                    case "Sedentary":
                        sedentary = true;
                        break;
                    case "Lightly Active":
                        lightlyActive = true;
                        break;
                    case "Very Active":
                        veryActive = true;
                        break;
                }

                double doubleAge = Double.parseDouble(age);
                double doubleWeight = Double.parseDouble(weight);
                double doubleHeight = Double.parseDouble(height);

                BMI = ((doubleWeight / doubleHeight) / doubleHeight) * 10000;
                String sBMI = String.valueOf(BMI);
                BMICalories = 10 * doubleWeight + 6.25 * doubleHeight - 5 * doubleAge;

                menVariables();
                womenVariables();
                
                Intent intent = new Intent(detailsActivity.this, goalsActivity.class);
                startActivity(intent);
            }
        });
    }


    public static void menVariables() {
        //men variables
        caloriesMenSedentarMentinere = BMICalories + 366;
        caloriesMenModeratMentinere = BMICalories + 844;
        caloriesMenActivMentinere = BMICalories + 998;

        caloriesMenSedentarDeficit = BMICalories + 139;
        caloriesMenModeratDeficit = BMICalories + 339;
        caloriesMenActivDeficit = BMICalories + 493;

        caloriesMenSedentarSurplus = BMICalories + 861;
        caloriesMenModeratSurplus = BMICalories + 1339;
        caloriesMenActivSurplus = BMICalories + 1493;

        caloriesMenSedentarMentinereResult = (String.valueOf(caloriesMenSedentarMentinere));
        caloriesMenModeratMentinereResult = (String.valueOf(caloriesMenModeratMentinere));
        caloriesMenActivMentinereResult = (String.valueOf(caloriesMenActivMentinere));

        caloriesMenSedentarDeficitResult = (String.valueOf(caloriesMenSedentarDeficit));
        caloriesMenModeratDeficitResult = (String.valueOf(caloriesMenModeratDeficit));
        caloriesMenActivDeficitResult = (String.valueOf(caloriesMenActivDeficit));

        caloriesMenSedentarSurplusResult = (String.valueOf(caloriesMenSedentarSurplus));
        caloriesMenModeratSurplusResult = (String.valueOf(caloriesMenModeratSurplus));
        caloriesMenActivSurplusResult = (String.valueOf(caloriesMenActivSurplus));
    }

    public void womenVariables() {

        //women variables
        caloriesWomenSedentarMentinere = BMICalories + 328;
        caloriesWomenModeratMentinere = BMICalories + 762;
        caloriesWomenActivMentinere = BMICalories + 901;

        caloriesWomenSedentarDeficit = BMICalories + 156;
        caloriesWomenModeratDeficit = BMICalories + 400;
        caloriesWomenActivDeficit = BMICalories + 500;

        caloriesWomenSedentarSurplus = BMICalories + 500;
        caloriesWomenModeratSurplus = BMICalories + 1000;
        caloriesWomenActivSurplus = BMICalories + 1100;


        caloriesWomenSedentarMentinereResult = String.valueOf(caloriesWomenSedentarMentinere);
        caloriesWomenModeratMentinereResult = String.valueOf(caloriesWomenModeratMentinere);
        caloriesWomenActivMentinereResult = String.valueOf(caloriesWomenActivMentinere);

        caloriesWomenSedentarDeficitResult = String.valueOf(caloriesWomenSedentarDeficit);
        caloriesWomenModeratDeficitResult = String.valueOf(caloriesWomenModeratDeficit);
        caloriesWomenActivDeficitResult = String.valueOf(caloriesWomenActivDeficit);

        caloriesWomenSedentarSurplusResult = String.valueOf(caloriesWomenSedentarSurplus);
        caloriesWomenModeratSurplusResult = String.valueOf(caloriesWomenModeratSurplus);
        caloriesWomenActivSurplusResult = String.valueOf(caloriesWomenActivSurplus);
    }
}

