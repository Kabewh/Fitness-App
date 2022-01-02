package com.example.fitnesstrackerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class registerUserActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    EditText confirmPassword;
    Button registerBtn;
    String URL = "http://10.0.2.2/login/register.php";
    String usernameS, passwordS, confirmPasswordS;
    //Button calculCaloriiBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_register);

        //StrictMode.enableDefaults();

        username = (EditText) findViewById(R.id.edtTxtUsername);
        password = (EditText) findViewById(R.id.edtTxtPassword);
        confirmPassword = (EditText) findViewById((R.id.edtTxtConfirmPassword));
        registerBtn = (Button) findViewById(R.id.registerBtn);

        StrictMode.ThreadPolicy policy = new
                StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        registerBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                usernameS = username.getText().toString();
                passwordS = password.getText().toString();
                passwordS = confirmPassword.getText().toString();
                //if (!usernameS.equals("") && !passwordS.equals("") && !confirmPasswordS.equals("")) {
                StringRequest stringRequest = new StringRequest(com.android.volley.Request.Method.POST, URL, new Response.Listener<String>() {
                    public void onResponse(String response) {
                        Log.d("res", response);
                        if (response.equals("success")) {
                            Toast.makeText(registerUserActivity.this, "Successfully registered", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(registerUserActivity.this, loginActivity.class);
                            startActivity(intent);
                        } else if (response.equals("failure")) {
                            Toast.makeText(registerUserActivity.this, "try again", Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.toString().trim(), Toast.LENGTH_SHORT).show();
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> data = new HashMap<>();
                        data.put("username", usernameS);
                        data.put("password", passwordS);
                        return data;
                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                requestQueue.add(stringRequest);
                //} else {
                //Toast.makeText(MainActivity.this, "fields can't be empty", Toast.LENGTH_SHORT).show();
                //}
            }
        });
    }
}