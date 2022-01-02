package com.example.fitnesstrackerapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class meActivity extends AppCompatActivity {

    TextView meUsername;
    TextView meHeight;
    TextView meWeight;
    TextView meActivityLevel;
    TextView meGender;
    TextView meAge;

    Button loseWeightIconBtn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_me);

        meUsername = (TextView) findViewById(R.id.meUsername);
        meHeight = (TextView) findViewById(R.id.meHeight);
        meWeight = (TextView) findViewById(R.id.meWeight);
        meActivityLevel = (TextView) findViewById(R.id.meActivityLevel);
        meGender = (TextView) findViewById(R.id.meGender);
        meAge = (TextView) findViewById(R.id.meAge);

        loseWeightIconBtn = (Button) findViewById(R.id.loseweighticonBtn);

        loseWeightIconBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(meActivity.this, mainWindowActivity.class);
                startActivity(intent);
            }
        });

        setDetails();
    }

    void setDetails(){
        String meAgeString = meAge.getText().toString();
        String meHeightString = meHeight.getText().toString();
        String meWeightString = meWeight.getText().toString();
        String meActivityLevelString = meActivityLevel.getText().toString();
        String meGenderString = meGender.getText().toString();

        meAgeString = detailsActivity.age;
        meHeightString = detailsActivity.height;
        meWeightString = detailsActivity.weight;
        meActivityLevelString = detailsActivity.activityLevel;
        meGenderString = detailsActivity.gender;

        meAge.setText(meAgeString);
        meHeight.setText(meHeightString);
        meWeight.setText(meWeightString);
        meActivityLevel.setText(meActivityLevelString);
        meGender.setText(meGenderString);
    }
}
