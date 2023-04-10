package com.hospital.models;

import java.beans.PropertyEditorSupport;

public class AppointmentTypeEditor extends PropertyEditorSupport {

	    @Override
	    public void setAsText(String text) {
	        AppointmentType appointmentType = new AppointmentType();
	        appointmentType.setName(text);
	        setValue(appointmentType);
	    }
	 
}
