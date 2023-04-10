package com.hospital.models;

import javax.persistence.*;

import java.time.LocalDateTime;

public class RegistrationDto {

    private int id;

    private Patient patient;

    private Doctor doctor;

    private String appointmentDate;

    private String appointmentType;

    private String diagnosis;

    private String prescription;
    
    // Getters and Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public String getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public String getAppointmentType() {
		return appointmentType;
	}

	public void setAppointmentType(String appointmentType) {
		this.appointmentType = appointmentType;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getPrescription() {
		return prescription;
	}

	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}
	  
    
		public Registration convertToRegistration() {
		    Registration registration = new Registration();
		    // set properties
		    registration.setId(this.getId());
		    registration.setPatient(this.getPatient());
		    registration.setDoctor(this.getDoctor());
		    registration.setAppointmentDate(this.getAppointmentDate());
		    registration.setDiagnosis(this.getDiagnosis());
		    registration.setPrescription(this.getPrescription());
		    // convert appointment type string to object
		    AppointmentType appointmentType = new AppointmentType();
		    appointmentType.setName(this.getAppointmentType());
		    registration.setAppointmentType(appointmentType);

		    return registration;
		}
    
}






