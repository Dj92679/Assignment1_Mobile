package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PatientRegister extends AppCompatActivity {

    Button P_RegisterSubmit;
    EditText Username, Password, Name, Surname,Address, Age, DOB, Gender, PhoneNumber, EContact, ENumber;
    String patientUsername, patientPassword, patientFirstName, patientSurname, patientAddress, patientGender, patientEmergencyContact, patientAge, patientDOB, patientPhoneNumber, patientEmergencyNumber;

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_register);

        Username = findViewById(R.id.P_RegisterUser);
        Password = findViewById(R.id.P_RegisterPass);
        Name = findViewById(R.id.P_RegisterFName);
        Surname = findViewById(R.id.P_RegisterSurname);
        Address = findViewById(R.id.P_RegisterAddress);
        Age = findViewById(R.id.P_RegisterAge);
        DOB = findViewById(R.id.P_RegisterDOB);
        Gender = findViewById(R.id.P_RegisterGender);
        PhoneNumber = findViewById(R.id.P_RegisterNumber);
        EContact = findViewById(R.id.P_RegisterEContact);
        ENumber = findViewById(R.id.P_RegisterENumber);

        P_RegisterSubmit = findViewById(R.id.P_RegisterSubmit);

        P_RegisterSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                patientUsername = Username.getText().toString();
                patientPassword = Password.getText().toString();
                patientFirstName = Name.getText().toString();
                patientSurname = Surname.getText().toString();
                patientAddress = Address.getText().toString();
                patientAge = Age.getText().toString();
                patientDOB = DOB.getText().toString();
                patientGender = Gender.getText().toString();
                patientPhoneNumber = PhoneNumber.getText().toString();
                patientEmergencyContact = EContact.getText().toString();
                patientEmergencyNumber = ENumber.getText().toString();

                Patient newPatient = new Patient(patientUsername, patientPassword,patientFirstName,patientSurname,patientAddress,patientAge,patientAge,patientGender,patientPhoneNumber,patientEmergencyContact,patientEmergencyNumber);

                db.collection("Patient").document(patientUsername).set(newPatient);

                Intent intent = new Intent(PatientRegister.this, Login.class);
                startActivity(intent);

            }
        });
    }
}