package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class Settings extends AppCompatActivity {

    FirebaseFirestore db_Delete = FirebaseFirestore.getInstance();
    Button DeleteAccount, ChangeAddress, ChangeContact, ChangeName, ChangeEContact;
    String patientUsername, etxtPatientUser, patientContact, patientEContact, patientAddress;
    EditText nameChange, addressChange, contactChange, econtactChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        DeleteAccount = findViewById(R.id.DeleteAccount);
        ChangeAddress = findViewById(R.id.ChangeAddress);
        ChangeContact = findViewById(R.id.ChangeContact);
        ChangeName =  findViewById(R.id.ChangeName);
        ChangeEContact = findViewById(R.id.ChangeEDetails);

        nameChange = findViewById(R.id.NameChange);
        addressChange = findViewById(R.id.AddressChange);
        contactChange = findViewById(R.id.ContactChange);
        econtactChange = findViewById(R.id.EDetailChange);

        patientAddress = addressChange.getText().toString();
        patientContact = contactChange.getText().toString();
        patientEContact = econtactChange.getText().toString();

        Intent newintent = getIntent();
        patientUsername = newintent.getStringExtra("patientUserName");

        DeleteAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                db_Delete.collection("Patient").document(patientUsername)
                        .delete();
                Intent intent = new Intent(Settings.this, Login.class);
                startActivity(intent);

            }
        });

            ChangeName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DocumentReference DocRef = db_Delete.collection("Patient").document(patientUsername);
                        etxtPatientUser = nameChange.getText().toString();
                            DocRef.update("patientFirstname",etxtPatientUser);
                            Intent intent = new Intent(Settings.this, Login.class);
                            startActivity(intent);
                }
            });


    }
}