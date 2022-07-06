package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class DoctorRegister extends AppCompatActivity {

    Button D_RegisterSubmit;
    EditText Username, Password, D_Name, D_Surname, D_RegNo, D_Number;
    String doctorUsername, doctorPassword, doctorFirstName, doctorSurname, doctorRegNum, doctorContact;

    FirebaseFirestore d_db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_register);

        Username = findViewById(R.id.D_RegisterUser);
        Password = findViewById(R.id.D_RegisterPass);
        D_Name = findViewById(R.id.D_RegisterFName);
        D_Surname = findViewById(R.id.D_RegisterSurname);
        D_RegNo = findViewById(R.id.D_RegisterRegNo);
        D_Number = findViewById(R.id.D_RegisterNumber);



        D_RegisterSubmit = findViewById(R.id.D_RegisterSubmit);

        D_RegisterSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                doctorUsername = Username.getText().toString();
                doctorPassword = Password.getText().toString();
                doctorFirstName = D_Name.getText().toString();
                doctorSurname = D_Surname.getText().toString();
                doctorRegNum = D_RegNo.getText().toString();
                doctorContact = D_Number.getText().toString();

                Doctor newDoctor = new Doctor(doctorUsername,doctorPassword,doctorFirstName,doctorSurname,doctorRegNum,doctorContact);
                Log.i("Save", "Save data to class");

                d_db.collection("Doctor").document(doctorUsername).set(newDoctor);
                Log.i("Makes Document","Make Document");

                Intent intent = new Intent(DoctorRegister.this, DoctorLogin.class);
                startActivity(intent);
                
                


            }
        });
    }
}