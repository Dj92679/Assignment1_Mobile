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
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class Login extends AppCompatActivity {

    FirebaseFirestore loginDB = FirebaseFirestore.getInstance();

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
                //not finished get help + extension
                loginDB.collection("Patient")
                        .whereEqualTo("patientUsername", PatientUser)
                        .get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                Log.i("Login", "Get's the data");
                                if (task.isSuccessful()) {
                                    Log.i("Login", "isSuccessful");
                                    for (QueryDocumentSnapshot document : task.getResult()) {
                                        Patient loginPatient = document.toObject(Patient.class);
                                        Log.i("Login", "Storing into CLass");
                                    }

                                }

                                loginDB.collection("Doctor")
                                        .whereEqualTo("doctorUsername", DoctorUser)
                                        .get()
                                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                                            @Override
                                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                                Log.i("Login", "Get's the data");
                                                if (task.isSuccessful()) {
                                                    Log.i("Login", "isSuccessful");
                                                    for (QueryDocumentSnapshot document : task.getResult()) {
                                                        Doctor LoginDoctor = document.toObject(Doctor.class);
                                                    }

                                                }

                                                if (Username.getText().toString().equals(DoctorUser) && Password.getText().toString().equals(DoctorPass)) {
                                                    Intent intent = new Intent(Login.this, DoctorMainScreen.class);
                                                    startActivity(intent);
                                                } else if (Username.getText().toString().equals(PatientUser) && Password.getText().toString().equals(PatientPass)) {
                                                    Intent intent = new Intent(Login.this, PatientHomeScreen.class);
                                                    startActivity(intent);
                                                } else {
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
                        });
            }
        });
    }
}