package com.example.assignment1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

public class DoctorLogin extends AppCompatActivity {

    FirebaseFirestore docLogin = FirebaseFirestore.getInstance();

    Button docLog, registerButton, swapPatient;
    ImageButton btnCall;
    String doctorUser, doctorPass;
    EditText docUsername, docPassword;
    String id,u,p,n,s,r,ph;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_login);

        docLog = findViewById(R.id.btn_Login2);
        registerButton = findViewById(R.id.RegisterBtn_First);
        swapPatient = findViewById(R.id.PLogin);
        docUsername = findViewById(R.id.etxtDocLogin);
        docPassword = findViewById(R.id.etxtDocPass);



        btnCall = findViewById(R.id.callMedical);

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:111"));
                startActivity(intent);
            }
        });

        docLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doctorUser = docUsername.getText().toString();
                doctorPass = docPassword.getText().toString();

                docLogin.collection("Doctor")
                        .whereEqualTo("doctorUsername", doctorUser)
                        .get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>()
                        {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task)
                            {
                                Log.i("Data", "Gets Data");
                                if (task.isSuccessful()) {
                                    DocumentSnapshot documentD = task.getResult().getDocuments().get(0);
                                    Doctor loginDoctor = new Doctor(documentD.getString("doctorUsername"), documentD.getString("doctorPassword"), documentD.getString("doctorFirstName"), documentD.getString("doctorSurname"), documentD.getString("doctorRegNumber"), documentD.getString("doctorPhoneNumber"));
                                }
                                else
                                {
                                    Log.i("Login", "Data not retrieved");
                                }
                            }
                        });
                if (docUsername.getText().toString().equals(doctorUser) && docPassword.getText().toString().equals(doctorPass)) {
                    Intent intent = new Intent(DoctorLogin.this, DoctorMainScreen.class);
                    intent.putExtra("doctorUserName", doctorUser);
                    startActivity(intent);

                }
                else {
                    Toast.makeText(DoctorLogin.this, "Please Enter a Valid Input", Toast.LENGTH_LONG).show();
                }

            }

        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DoctorLogin.this, PatientOrDoctor.class);
                startActivity(intent);
            }
        });

        swapPatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( DoctorLogin.this, Login.class);
                startActivity(intent);
            }
        });



    }
}