package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class PatientForms extends AppCompatActivity {

    FirebaseFirestore form_db = FirebaseFirestore.getInstance();

    Button formSubmit;
    EditText f_GP, f_religion, MedHis, incidentReport;
    String prevMedHis,religion,GP, form_Incident;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_forms);

       MedHis = findViewById(R.id.PrevMedHis);
       f_GP = findViewById(R.id.GPAdmit);
       f_religion = findViewById(R.id.ReligionAdmit);
       incidentReport = findViewById(R.id.Incident);



       formSubmit = findViewById(R.id.FormSubmitBtn);



       formSubmit.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               prevMedHis = MedHis.getText().toString();
               religion = f_religion.getText().toString();
               GP = f_GP.getText().toString();
               form_Incident = incidentReport.getText().toString();

               MedForm report = new MedForm(prevMedHis, religion, GP, form_Incident);
               CollectionReference formUser = form_db.collection("Form");
               formUser.add(report);

               Intent intent = new Intent(PatientForms.this, PatientHomeScreen.class);
               startActivity(intent);
               Toast.makeText(PatientForms.this, "Form submitted", Toast.LENGTH_LONG).show();


           }
       });


    }
}