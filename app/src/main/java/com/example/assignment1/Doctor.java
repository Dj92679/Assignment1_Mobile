package com.example.assignment1;

import com.google.firebase.firestore.FirebaseFirestore;

public class Doctor
{
    private String doctorUsername;
    private String doctorPassword;
    private String doctorFirstName;
    private String doctorSurname;
    private String doctorRegoNum;
    private String doctorPhoneNumber;

    public Doctor(String doctorUsername, String doctorPassword, String doctorFirstName, String doctorSurname,String doctorRegoNum, String doctorPhoneNumber) {
        this.doctorUsername = doctorUsername;
        this.doctorPassword = doctorPassword;
        this.doctorFirstName = doctorFirstName;
        this.doctorSurname = doctorSurname;
        this.doctorRegoNum = doctorRegoNum;
        this.doctorPhoneNumber = doctorPhoneNumber;
    }

    public String getDoctorUsername() {
        return doctorUsername;
    }

    public void setDoctorUsername(String doctorUsername) {
        this.doctorUsername = doctorUsername;
    }

    public String getDoctorPassword() {
        return doctorPassword;
    }

    public void setDoctorPassword(String doctorPassword) {
        this.doctorPassword = doctorPassword;
    }

    public String getDoctorFirstName() {
        return doctorFirstName;
    }

    public void setDoctorFirstName(String doctorFirstName) {
        this.doctorFirstName = doctorFirstName;
    }

    public String getDoctorSurname() {
        return doctorSurname;
    }

    public void setDoctorSurname(String doctorSurname) {
        this.doctorSurname = doctorSurname;
    }

    public String getDoctorRegoNum() {
        return doctorRegoNum;
    }

    public void setDoctorRegoNum(String doctorRegoNum) {
        this.doctorRegoNum = doctorRegoNum;
    }

    public String getDoctorPhoneNumber() {
        return doctorPhoneNumber;
    }

    public void setDoctorPhoneNumber(String doctorPhoneNumber) {
        this.doctorPhoneNumber = doctorPhoneNumber;
    }
}
