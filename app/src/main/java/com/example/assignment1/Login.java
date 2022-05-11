package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    ImageButton btnCall;
    Button LoginBtn1, RegisterBtnLogin;
    String DoctorUser, DoctorPass, PatientUser, PatientPass;
    EditText Username,Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        LoginBtn1 = findViewById(R.id.btn_LoginFirst);
        RegisterBtnLogin = findViewById(R.id.RegisterBtn_First);
        Username = findViewById(R.id.etxtUserLogin);
        Password = findViewById(R.id.etxtUserPass);

        DoctorUser = "HVDHBDoc";
        DoctorPass = "Password123";
        PatientUser = "TestUser";
        PatientPass = "TestPass1";

        btnCall = findViewById(R.id.callMedical);

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:111"));
                startActivity(intent);
            }
        });

        LoginBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Username.getText().toString().equals(DoctorUser) && Password.getText().toString().equals(DoctorPass))
                {
                            Intent intent = new Intent(Login.this, DoctorMainScreen.class);
                            startActivity(intent);
                }
                else if (Username.getText().toString().equals(PatientUser)  && Password.getText().toString().equals( PatientPass))
                {
                            Intent intent = new Intent(Login.this, PatientHomeScreen.class);
                            startActivity(intent);
                }
                else
                {
                    Toast.makeText(Login.this, "Please Enter a Valid Input", Toast.LENGTH_LONG).show();
                }
            }
        });

        RegisterBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, PatientOrDoctor.class);
                startActivity(intent);
            }
        });

    }
}