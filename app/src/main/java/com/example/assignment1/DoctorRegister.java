package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DoctorRegister extends AppCompatActivity {

    Button D_RegisterSubmit;
    EditText Username, Password, D_Name, D_Surname, D_RegNo, D_Number;

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
                Intent intent = new Intent(DoctorRegister.this, DoctorMainScreen.class);
                startActivity(intent);
            }
        });
    }
}