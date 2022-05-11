package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PatientHomeScreen extends AppCompatActivity {

    Button CreateForm, ViewOldForms, P_Settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paitent_home_screen);

        CreateForm = findViewById(R.id.CreateFormBtn);
        ViewOldForms = findViewById(R.id.ViewFormBtn);
        P_Settings = findViewById(R.id.PatientSettings);

        CreateForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PatientHomeScreen.this, PatientForms.class);
                startActivity(intent);
            }
        });

        ViewOldForms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PatientHomeScreen.this, ViewHistory.class);
                startActivity(intent);
            }
        });

        P_Settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PatientHomeScreen.this, Settings.class);
                startActivity(intent);
            }
        });
    }
}