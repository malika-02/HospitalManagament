package com.hospital.ns.dao;

import java.util.List;

import com.hospital.models.Patient;

public interface PatientDAO {

	List<Patient> getAllPatients();

	void addPatient(Patient patient);

	Patient getPatientById(int id);

	void updatePatient(Patient patient);

	void deletePatient(int id);

}
