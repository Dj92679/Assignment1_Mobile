package com.example.assignment1;

public class MedForm {

    private String GP;
    private String religion;
    private String prevMedHis;
    private String form_Incident;

    public MedForm(String GP, String religion, String prevMedHis, String form_Incident) {

        this.GP = GP;
        this.religion = religion;
        this.prevMedHis = prevMedHis;
        this.form_Incident = form_Incident;
    }

    public String getGP() {
        return GP;
    }

    public void setGP(String GP) {
        this.GP = GP;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getPrevMedHis() {
        return prevMedHis;
    }

    public void setPrevMedHis(String prevMedHis) {
        this.prevMedHis = prevMedHis;
    }

    public String getForm_Incident() {
        return form_Incident;
    }

    public void setForm_Incident(String form_Incident) {
        this.form_Incident = form_Incident;
    }
}

