package com.hospital.js.dao;

import java.util.List;

import com.hospital.models.Doctor;

public interface DoctorDao {
	void saveOrUpdateDoctor(Doctor doctor);

    void deleteDoctor(int id);

    Doctor getDoctorById(int id);

    List<Doctor> getAllDoctors();
}
