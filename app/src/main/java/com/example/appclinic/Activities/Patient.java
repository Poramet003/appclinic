package com.example.appclinic.Activities;

public class Patient {

    private String patientFname;
    private String patientLname;
    private String patientCard;
    private String patientPhone;
    private String patientId;


    public Patient() {

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

    public Patient(String patientId, String patientFname, String patientLname, String patientPhone, String patientCard){
        this.patientId = patientId;
        this.patientFname = patientFname;
        this.patientLname = patientLname;
        this.patientPhone = patientPhone;
        this.patientCard = patientCard;

    }



}