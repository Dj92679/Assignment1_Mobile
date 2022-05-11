package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class Settings extends AppCompatActivity {

    Button DeleteAccount, ChangeAddress, ChangeContact, ChangeName, ChangeEContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        DeleteAccount = findViewById(R.id.DeleteAccount);
        ChangeAddress = findViewById(R.id.ChangeAddress);
        ChangeContact = findViewById(R.id.ChangeContact);
        ChangeName =  findViewById(R.id.ChangeName);
        ChangeEContact = findViewById(R.id.ChangeEDetails);
    }
}