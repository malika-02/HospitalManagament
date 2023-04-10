package com.hospital.ns.dao;

import java.util.List;

import com.hospital.models.Doctor;

public interface DoctorDAO {

	void addDoctor(Doctor doctor);

	List<Doctor> getAllDoctors();

	Doctor getDoctorById(int id);

	void updateDoctor(Doctor doctor);

	void deleteDoctor(int id);

}
