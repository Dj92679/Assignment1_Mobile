package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PatientForms extends AppCompatActivity {

    Button formSubmit;
    EditText GP, religion, prevMedHis, incidentReport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_forms);

       prevMedHis = findViewById(R.id.PrevMedHis);
       GP = findViewById(R.id.GPAdmit);
       religion = findViewById(R.id.ReligionAdmit);
       incidentReport = findViewById(R.id.Incident);

       formSubmit = findViewById(R.id.FormSubmitBtn);

       formSubmit.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(PatientForms.this, PatientHomeScreen.class);
               startActivity(intent);
           }
       });


    }
}