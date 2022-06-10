package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

public class DoctorSettings extends AppCompatActivity {
    EditText DNameChange;
    Button DChangeName, DeleteAccount;
    String u,p,n,s,r,ph;

    FirebaseFirestore dbd_Delete = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_settings);

        DeleteAccount = findViewById(R.id.AccountDelete);
        DNameChange = findViewById(R.id.DNameChange);
        DChangeName = findViewById(R.id.DChangeName);

        DeleteAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Doctor doctor = new Doctor(u,p,n,s,r,ph);

                dbd_Delete.collection("Doctor").document(doctor.getDoctorUsername())
                        .delete()
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Log.i("Success", "Delete");

                            }
                        });


                Intent intent = new Intent(DoctorSettings.this, DoctorLogin.class);
                startActivity(intent);

            }
        });
    }
}