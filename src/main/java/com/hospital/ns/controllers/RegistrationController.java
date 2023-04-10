package com.hospital.ns.controllers;



import java.beans.PropertyEditor;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.hospital.models.AppointmentType;
import com.hospital.models.Doctor;
import com.hospital.models.Patient;
import com.hospital.models.Registration;
import com.hospital.models.RegistrationDto;
import com.hospital.ns.dao.AppointmentTypeDAO;
import com.hospital.ns.dao.DoctorDAO;
import com.hospital.ns.dao.PatientDAO;
import com.hospital.ns.dao.RegistrationDAO;

@Controller
@RequestMapping("/registration")

	
	public class RegistrationController {

	    @Autowired
	    private RegistrationDAO registrationDAO;

	    @Autowired
	    private PatientDAO patientDAO;

	    @Autowired
	    private DoctorDAO doctorDAO;

	    @Autowired
	    private AppointmentTypeDAO appointmentTypeDAO;

	    @GetMapping("/list")
	    public ModelAndView listRegistrations() {
	        List<Registration> registrations = registrationDAO.getAllRegistrations();
	        return new ModelAndView("registrationList", "registrations", registrations);
	    }

	    @GetMapping("/add")
	    public ModelAndView addRegistrationForm() {
	        List<Patient> patients = patientDAO.getAllPatients();
	        List<Doctor> doctors = doctorDAO.getAllDoctors();
	        List<AppointmentType> appointmentTypes = appointmentTypeDAO.getAllAppointmentTypes();
	        ModelAndView modelAndView = new ModelAndView("addRegistration");
	        modelAndView.addObject("registration", new Registration());
	        modelAndView.addObject("patients", patients);
	        modelAndView.addObject("doctors", doctors);
	        modelAndView.addObject("appointmentTypes", appointmentTypes);
	        return modelAndView;
	    }

	    @PostMapping("/add")
	    public String addRegistration(@ModelAttribute("registration") Registration registration
	           ) {
	    
	        registrationDAO.addRegistration(registration);
	        return "redirect:/registration/list";
	    }



		@GetMapping("/edit/{id}")
	    public ModelAndView editRegistrationForm(@PathVariable("id") int id) {
	        Registration registration = registrationDAO.getRegistrationById(id);
	        List<Patient> patients = patientDAO.getAllPatients();
	        List<Doctor> doctors = doctorDAO.getAllDoctors();
	        List<AppointmentType> appointmentTypes = appointmentTypeDAO.getAllAppointmentTypes();
	        ModelAndView modelAndView = new ModelAndView("editRegistration");
	        modelAndView.addObject("registration", registration);
	        modelAndView.addObject("patients", patients);
	        modelAndView.addObject("doctors", doctors);
	        modelAndView.addObject("appointmentTypes", appointmentTypes);
	        return modelAndView;
	    }

	    @PostMapping("/edit/{id}")
	    public String updateRegistration(@PathVariable("id") int id, @ModelAttribute("registration") Registration registration) {
	        registration.setId(id);
	        registrationDAO.updateRegistration(registration);
	        return "redirect:/registration/list";
	    }

	    @GetMapping("/delete/{id}")
	    public String deleteRegistration(@PathVariable("id") int id) {
	        registrationDAO.deleteRegistration(id);
	        return "redirect:/registration/list";
	    }
	    
	    
	   
	}


