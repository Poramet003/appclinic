package com.example.appclinic.Activities;

import android.widget.Spinner;

public class Patient {

    private String patientFname;
    private String patientLname;
    private String patientCard;
    private String patientPhone;
    private String patientId;
    private String patientGander;


    public Patient() {

    }

    public Patient(String id, String patientFname, String patientLname, String patientCard, String patientPhone) {
    }

    public String getPatientFname() {
        return patientFname;
    }

    public String getPatientLname() {
        return patientLname;
    }

    public String getPatientCard() {
        return patientCard;
    }

    public String getPatientPhone() {
        return patientPhone;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getPatientGander() {
        return patientGander;
    }

    public Patient(String id, String patientId, String patientFname, String patientLname, String patientGander, String patientPhone, String patientCard){
        this.patientId = patientId;
        this.patientFname = patientFname;
        this.patientLname = patientLname;
        this.patientGander = patientGander;
        this.patientPhone = patientPhone;
        this.patientCard = patientCard;

    }



}