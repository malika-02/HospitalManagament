package com.hospital.ns.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hospital.models.AppointmentType;
import com.hospital.ns.dao.AppointmentTypeDAO;

@Controller
public class AppointmentTypeController {

	@Autowired
	private AppointmentTypeDAO appointmentTypeDAO;

	@RequestMapping(value = "/appointmentType/add", method = RequestMethod.GET)
	public ModelAndView addAppointmentTypeForm() {
	    return new ModelAndView("addAppointmentType", "appointmentType", new AppointmentType());
	}

	@RequestMapping(value = "/appointmentType/add", method = RequestMethod.POST)
	public ModelAndView addAppointmentType(@ModelAttribute("appointmentType") AppointmentType appointmentType, BindingResult result) {
	    appointmentTypeDAO.addAppointmentType(appointmentType);
	    return new ModelAndView("redirect:/appointmentType/list");
	}

	@RequestMapping(value = "/appointmentType/list", method = RequestMethod.GET)
	public ModelAndView listAppointmentTypes() {
	    List<AppointmentType> appointmentTypes = appointmentTypeDAO.getAllAppointmentTypes();
	    return new ModelAndView("appointmentTypeList", "appointmentTypes", appointmentTypes);
	}

	@RequestMapping(value = "/appointmentType/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editAppointmentTypeForm(@PathVariable("id") int id) {
	    AppointmentType appointmentType = appointmentTypeDAO.getAppointmentTypeById(id);
	    return new ModelAndView("editAppointmentType", "appointmentType", appointmentType);
	}

	@RequestMapping(value = "/appointmentType/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editAppointmentType(@ModelAttribute("appointmentType") AppointmentType appointmentType, BindingResult result) {
	    appointmentTypeDAO.updateAppointmentType(appointmentType);
	    return new ModelAndView("redirect:/appointmentType/list");
	}

	@RequestMapping(value = "/appointmentType/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteAppointmentType(@PathVariable("id") int id) {
	    appointmentTypeDAO.deleteAppointmentType(id);
	    return new ModelAndView("redirect:/appointmentType/list");
	}

}