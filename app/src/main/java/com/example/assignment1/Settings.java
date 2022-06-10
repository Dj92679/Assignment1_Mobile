package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

public class Settings extends AppCompatActivity {

    FirebaseFirestore db_Delete = FirebaseFirestore.getInstance();
    Button DeleteAccount, ChangeAddress, ChangeContact, ChangeName, ChangeEContact;
    String u,p,n,s,add,a,d,g,ph,ec,eph;

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

                Patient patient = new Patient(u,p,n,s,add,a,d,g,ph,ec,eph);

                db_Delete.collection("Patient").document(patient.getPatientUsername())
                        .delete()
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Log.i("Success", "Delete");
                            }
                        });


                Intent intent = new Intent(Settings.this, Login.class);
                startActivity(intent);

            }
        });
    }
}