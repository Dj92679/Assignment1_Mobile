package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PatientForms extends AppCompatActivity {

    EditText Incident, PrevMedHis, ReligionAdmit, GPAdmit;
    Button FormSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_forms);

        Incident = findViewById(R.id.Incident);
        PrevMedHis = findViewById(R.id.PrevMedHis);
        ReligionAdmit = findViewById(R.id.ReligionAdmit);
        GPAdmit = findViewById(R.id.GPAdmit);

        FormSubmit = findViewById(R.id.PatientSettings);

        FormSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PatientForms.this, Settings.class);
                startActivity(intent);
            }
        });
    }
}