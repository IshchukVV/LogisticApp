package com.example.logisticapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Home extends AppCompatActivity implements View.OnClickListener {
    Button btnScan;
    String[] department = {"Department1", "Department2", "Department3", "Department4", "Department5"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle(null);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnScan = (Button) findViewById(R.id.btnScan);
        btnScan.setOnClickListener(this);

        Spinner spinner = (Spinner) findViewById(R.id.department);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, department);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnScan:
                Intent camAct = new Intent(this, BarCodeReader.class);
                startActivity(camAct);
                break;
            default:
                break;
        }
    }
}