package com.hospital.ns.dao;

import java.util.List;

import com.hospital.models.AppointmentType;

public interface AppointmentTypeDAO {

	void addAppointmentType(AppointmentType appointmentType);

	List<AppointmentType> getAllAppointmentTypes();

	AppointmentType getAppointmentTypeById(int id);

	void updateAppointmentType(AppointmentType appointmentType);

	void deleteAppointmentType(int id);

}
