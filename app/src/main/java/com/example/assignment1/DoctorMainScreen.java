package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.firestore.FirebaseFirestore;

public class DoctorMainScreen extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    Button D_Settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_main_screen);

        D_Settings = findViewById(R.id.DoctorSettings);

        D_Settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DoctorMainScreen.this, DoctorSettings.class);
                startActivity(intent);
            }
        });
    }
}