package com.example.logisticapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

public class Auth extends AppCompatActivity implements View.OnClickListener {

    String[] location = {"Location1", "Location2", "Location3", "Location4", "Location5"};

    Button btnSingIn;
    EditText login, password;
    ImageView showPassword;
    int visibilityCheck = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.SignInScreenTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        btnSingIn = (Button) findViewById(R.id.btnSignIn);
        btnSingIn.setOnClickListener(this);
        login = (EditText) findViewById(R.id.login);
        password = (EditText) findViewById(R.id.password);
        showPassword = (ImageView) findViewById(R.id.showPassword);
        showPassword.setOnClickListener(this);

            Spinner spinner = (Spinner) findViewById(R.id.location);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, location);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
            spinner.setSelection(0);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSignIn:
                Intent signIn = new Intent(this, Home.class);
                startActivity(signIn);
                break;
            case R.id.showPassword:
                switch (visibilityCheck) {
                    case 1:
                        visibilityCheck = 0;
                        showPassword.setImageResource(R.drawable.ic_visibility_black_18dp);
                        password.setTransformationMethod(null);
                        break;
                    default:
                        visibilityCheck = 1;
                        showPassword.setImageResource(R.drawable.ic_visibility_off_black_18dp);
                        password.setTransformationMethod(new PasswordTransformationMethod());
                        break;
                }
                break;
            default:
                break;
        }

    }
}