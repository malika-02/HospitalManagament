package com.hospital.ms.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hospital.models.Doctor;
import com.hospital.models.Patient;

public interface PatientDao {
	public List<Patient> list();

	void saveOrUpdatePatient(Patient patient);

	void deletePatient(int id);

	Patient getPatientById(int id);
}
