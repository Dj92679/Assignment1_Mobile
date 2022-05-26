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
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class Login extends AppCompatActivity {

    FirebaseFirestore loginDB = FirebaseFirestore.getInstance();

    ImageButton btnCall;
    Button LoginBtn1, RegisterBtnLogin;
    String doctorUser, doctorPass, patientUser, patientPass;
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

        patientUser = Username.getText().toString();
        patientPass = Password.getText().toString();
        doctorUser = Username.getText().toString();
        doctorUser = Password.getText().toString();

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
            public void onClick(View view)
            {
                patientUser = Username.getText().toString();
                patientPass = Password.getText().toString();
                doctorUser = Username.getText().toString();
                doctorUser = Password.getText().toString();
                //not finished get help not storing into class
                loginDB.collection("Patient")
                        .whereEqualTo("patientUsername", patientUser)
                        .get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                if (task.isSuccessful()) {
                                    DocumentSnapshot document = task.getResult().getDocuments().get(0);
                                    Patient loginPatient = new Patient(document.getString("patientUsername"),document.getString("patientPassword"),document.getString("patientFirstName"),document.getString("patientSurname"), document.getString("patientAddress"),document.getString("patientAge"),document.getString("patientDOB"),document.getString("patientGender"),document.getString("patientPhoneNumber"),document.getString("patientEmergencyContact"),document.getString("patientEmergencyNumber"));
                                }
                                else
                                {
                                    Log.i("Login", "Data not retrieved");
                                }

                    /*  loginDB.collection("Doctor")
                               .whereEqualTo("doctorUsername", doctorUser)
                               .get()
                               .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>()
                               {
                                    @Override
                                    public void onComplete(@NonNull Task<QuerySnapshot> task)
                                    {
                                            if (task.isSuccessful()) {
                                               DocumentSnapshot documentD = task.getResult().getDocuments().get(0);
                                               Doctor loginDoctor = new Doctor(documentD.getString("doctorUsername"), documentD.getString("doctorPassword"), documentD.getString("doctorFirstName"), documentD.getString("doctorSurname"), documentD.getString("doctorRegNumber"), documentD.getString("doctorPhoneNumber"));
                                            }
                                            else
                                            {
                                                    Log.i("Login", "Data not retrieved");
                                            }
                                    }
                               });*/
                            }
                        });
                if (Username.getText().toString().equals(doctorUser) && Password.getText().toString().equals(doctorPass)) {
                    Intent intent = new Intent(Login.this, DoctorMainScreen.class);
                    startActivity(intent);
                }
                else if (Username.getText().toString().equals(patientUser) && Password.getText().toString().equals(patientPass)) {
                    Intent intent = new Intent(Login.this, PatientHomeScreen.class);
                    startActivity(intent);
                }
                else {
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