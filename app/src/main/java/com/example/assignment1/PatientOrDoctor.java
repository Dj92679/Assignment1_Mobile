package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class PatientOrDoctor extends AppCompatActivity {

    Button PatientBtn, DoctorBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_or_doctor);

        PatientBtn = findViewById(R.id.Patientsubmit);

        DoctorBtn = findViewById(R.id.DoctorSubmit);

        PatientBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PatientOrDoctor.this, PatientRegister.class);
                startActivity(intent);
            }
        });

        DoctorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PatientOrDoctor.this, DoctorRegister.class);
                startActivity(intent);
            }
        });
    }
}