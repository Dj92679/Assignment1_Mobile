package com.example.assignment1;

public class Patient
{
    private String patientUsername;
    private String patientPassword;
    private String patientFirstname;
    private String patientSurname;
    private String patientAddress;
    private int patientAge;
    private int patientDOB;
    private String patientGender;
    private double patientPhoneNumber;
    private String patientEmergencyContact;
    private double patientEmergencyNumber;

    public Patient(String patientUsername, String patientPassword, String patientFirstname, String patientSurname, String patientAddress, int patientAge, int patientDOB, String patientGender, double patientPhoneNumber, String patientEmergencyContact, double patientEmergencyNumber) {
        this.patientUsername = patientUsername;
        this.patientPassword = patientPassword;
        this.patientFirstname = patientFirstname;
        this.patientSurname = patientSurname;
        this.patientAddress = patientAddress;
        this.patientAge = patientAge;
        this.patientDOB = patientDOB;
        this.patientGender = patientGender;
        this.patientPhoneNumber = patientPhoneNumber;
        this.patientEmergencyContact = patientEmergencyContact;
        this.patientEmergencyNumber = patientEmergencyNumber;
    }

    //Getter and Setter for Patient Usernames
    public String getPatientUsername() {
        return patientUsername;
    }

    public void setPatientUsername(String patientUsername) {
        this.patientUsername = patientUsername;
    }

    //Getter and Setter for Patient Passwords
    public String getPatientPassword() {
        return patientPassword;
    }

    public void setPatientPassword(String patientPassword) {
        this.patientPassword = patientPassword;
    }

    //Getter and Setter for Patient First names
    public String getPatientFirstname() {
        return patientFirstname;
    }

    public void setPatientFirstname(String patientFirstname) {
        this.patientFirstname = patientFirstname;
    }

    //Getter and Setter for Patient Surnames
    public String getPatientSurname() {
        return patientSurname;
    }

    public void setPatientSurname(String patientSurname) {
        this.patientSurname = patientSurname;
    }

    //Getter and Setter for Patient Address
    public String getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }

    //Getter and Setter for Patient Age
    public int getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(int patientAge) {
        this.patientAge = patientAge;
    }

    //Getter and Setter for Patient Date of Birth
    public int getPatientDOB() {
        return patientDOB;
    }

    public void setPatientDOB(int patientDOB) {
        this.patientDOB = patientDOB;
    }

    //Getter and Setter for Patient Gender
    public String getPatientGender() {
        return patientGender;
    }

    public void setPatientGender(String patientGender) {
        this.patientGender = patientGender;
    }

    //Getter and Setter for Patient Phone Numbers
    public double getPatientPhoneNumber() {
        return patientPhoneNumber;
    }

    public void setPatientPhoneNumber(double patientPhoneNumber) {
        this.patientPhoneNumber = patientPhoneNumber;
    }

    //Getter and Setter for Patient Emergency Contacts
    public String getPatientEmergencyContact() {
        return patientEmergencyContact;
    }

    public void setPatientEmergencyContact(String patientEmergencyContact) {
        this.patientEmergencyContact = patientEmergencyContact;
    }

    //Getter and Setter for Patient Emergency Contact Numbers
    public double getPatientEmergencyNumber() {
        return patientEmergencyNumber;
    }

    public void setPatientEmergencyNumber(double patientEmergencyNumber) {
        this.patientEmergencyNumber = patientEmergencyNumber;
    }
}
