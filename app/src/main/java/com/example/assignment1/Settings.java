package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.firestore.FirebaseFirestore;

public class Settings extends AppCompatActivity {

    FirebaseFirestore db_Delete = FirebaseFirestore.getInstance();
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

        DeleteAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                db_Delete.collection("Doctor").document(/*"user account"*/)
                        .delete();
            }
        });
    }
}