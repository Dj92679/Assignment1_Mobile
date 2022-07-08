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

public class DoctorSettings extends AppCompatActivity {
    EditText DNameChange;
    Button DChangeName, DeleteAccount;
    String doctorUserName, doctorName;

    FirebaseFirestore dbd_Delete = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_settings);

        DeleteAccount = findViewById(R.id.AccountDelete);
        DNameChange = findViewById(R.id.DNameChange);
        DChangeName = findViewById(R.id.DChangeName);

        Intent newIntent = getIntent();
        doctorUserName = newIntent.getStringExtra("doctorUserName");

        DeleteAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                dbd_Delete.collection("Doctor").document(doctorUserName)
                        .delete();
                                Intent intent = new Intent(DoctorSettings.this, DoctorLogin.class);
                                startActivity(intent);
            }
        });

        DChangeName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DocumentReference DocRef = dbd_Delete.collection("Doctor").document(doctorUserName);
               doctorName = DNameChange.getText().toString();
                DocRef.update("doctorFirstname",doctorName);
                Intent intent = new Intent(DoctorSettings.this, Login.class);
                startActivity(intent);
            }
        });
    }
}