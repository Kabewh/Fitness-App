package com.example.fitnesstrackerapp;

import static com.example.fitnesstrackerapp.detailsActivity.caloriesMenSedentarMentinereResult;
import static com.example.fitnesstrackerapp.detailsActivity.femaleSelected;
import static com.example.fitnesstrackerapp.detailsActivity.maleSelected;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class goalsActivity extends AppCompatActivity {

    Button loseWeight;
    Button maintainWeight;
    Button gainWeight;
    public static boolean loseWeightClicked;
    public static boolean maintainWeightClicked;
    public static boolean gainWeightClicked;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_goals);

        loseWeight = (Button) findViewById(R.id.loseWeightBtn);
        maintainWeight = (Button) findViewById(R.id.maintainBtn);
        gainWeight = (Button) findViewById(R.id.gainWeightBtn);

        loseWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loseWeightClicked = true;
                Intent intent = new Intent(goalsActivity.this, mainWindowActivity.class);
                startActivity(intent);
            }
        });

        maintainWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maintainWeightClicked = true;
                Intent intent = new Intent(goalsActivity.this, mainWindowActivity.class);
                startActivity(intent);
            }
        });

        gainWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gainWeightClicked = true;
                Intent intent = new Intent(goalsActivity.this, mainWindowActivity.class);
                startActivity(intent);
            }
        });


    }
}
