package com.hospital.ns.dao;

import java.util.List;

import com.hospital.models.Registration;

public interface RegistrationDAO {

	void addRegistration(Registration registration);

	List<Registration> getAllRegistrations();

	Registration getRegistrationById(int id);

	void updateRegistration(Registration registration);

	void deleteRegistration(int id);

}
