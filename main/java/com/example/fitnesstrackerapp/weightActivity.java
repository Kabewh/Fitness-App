package com.example.fitnesstrackerapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class weightActivity extends AppCompatActivity {

    //pgbPercentage
    public static String goalWeightString;
    public static boolean updateWeightClicked;
    public static String editTextCurrentWeightString;

    String currWeightString;
    double currWeightDouble;
    double goalWeightDouble;
    double editTextCurrentWeightDouble;
    double diffWeightGoal;
    double diffWeightCurr;
    double progressBarIndex;

    ProgressBar progressBar;
    EditText goalWeight;
    EditText editTextCurrentWeight;
    TextView currWeight;
    Button updateWeightBtn;
    Button goBackBtn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_weight);

        goalWeight = (EditText) findViewById(R.id.editTxtGoalWeight);
        editTextCurrentWeight = (EditText) findViewById(R.id.editTextCurrentWeight);

        currWeight = (TextView) findViewById(R.id.txtCurrWeight);

        updateWeightBtn = (Button) findViewById(R.id.updateWeightBtn);
        goBackBtn = (Button) findViewById(R.id.loseweighticonbtn);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        currWeightString = detailsActivity.weight;
        currWeight.setText(currWeightString);

        editTextCurrentWeightString = editTextCurrentWeight.getText().toString();
        updateWeightBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                progressBarDiffWeightCurr();
                progressBarDiffWeightGoal();
                calculateProgressBarIndex();
                checkWeight();
                updateWeightClicked = true;
            }
        });

        goBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(weightActivity.this, mainWindowActivity.class);
                startActivity(intent);
            }
        });
    }

    public void progressBarDiffWeightCurr(){
        editTextCurrentWeightDouble = Double.parseDouble(editTextCurrentWeight.getText().toString());
        diffWeightCurr = currWeightDouble - editTextCurrentWeightDouble;
        if (diffWeightCurr < 0){
            diffWeightCurr = diffWeightCurr * (-1);
        }
        String diffWeightCurrString = Double.toString(diffWeightCurr);
    }

    public void progressBarDiffWeightGoal(){
        currWeightDouble = Double.parseDouble(currWeight.getText().toString());
        goalWeightDouble = Double.parseDouble(goalWeight.getText().toString());
        diffWeightGoal = currWeightDouble - goalWeightDouble;
        if (diffWeightGoal < 0){
            diffWeightGoal = diffWeightGoal * (-1);
        }
        String diffWeightGoalString = Double.toString(diffWeightGoal);
        int diffWeightGoalInt = (int) Math.round(diffWeightGoal);
    }

    public void calculateProgressBarIndex(){
        if (progressBarIndex < 0){
            progressBarIndex = progressBarIndex * (-1);
        }
        progressBarIndex = (diffWeightCurr/diffWeightGoal) * 100;
        int progressBarIndexInt = (int) Math.round(progressBarIndex);
        progressBar.setProgress(progressBarIndexInt);
        String progressBarIndexString = Double.toString(progressBarIndex);
    }

    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if ( v instanceof EditText) {
                Rect outRect = new Rect();
                v.getGlobalVisibleRect(outRect);
                if (!outRect.contains((int)event.getRawX(), (int)event.getRawY())) {
                    v.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
        }
        return super.dispatchTouchEvent(event);
    }

    public void checkWeight(){
        if(currWeightDouble > editTextCurrentWeightDouble){
            if(editTextCurrentWeightDouble < goalWeightDouble)
            Toast.makeText(weightActivity.this, "Target weight reached! Set a new weight target!", Toast.LENGTH_SHORT).show();
        }
        if(currWeightDouble < editTextCurrentWeightDouble){
            if(editTextCurrentWeightDouble > goalWeightDouble)
                Toast.makeText(weightActivity.this, "Target weight reached! Set a new weight target!", Toast.LENGTH_SHORT).show();
        }
    }

}
