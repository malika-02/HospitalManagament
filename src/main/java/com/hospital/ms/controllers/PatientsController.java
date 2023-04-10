package com.hospital.ms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hospital.models.Doctor;
import com.hospital.models.Patient;
import com.hospital.ms.dao.PatientDao;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/patients")
public class PatientsController {
	@Autowired
    private PatientDao patientDao;
	 @GetMapping("/list")
	    public String listDoctors(Model model) {
	        List<Patient> patients = patientDao.list();
	        model.addAttribute("patients", patients);
	        return "list-patient";
	    }
		@GetMapping("/")
	    public String openform(Model model) {
	        return "patient-form";
	    }
	  // to store the patient in db 
	  @PostMapping("/savepatient")
	    public String saveOrUpdateDoctor(@ModelAttribute("patient") Patient patient) {
		  patientDao.saveOrUpdatePatient(patient);
	        return "redirect:/patients/list";
	    }
	  // to delete from db
	  @GetMapping("/delete")
	    public String deletePatient(@RequestParam("id") int id) {
	    	System.out.println(id);
			Patient patient = patientDao.getPatientById(id);
//			System.out.println(patient.getSpecialization());
			patientDao.deletePatient(id);
//	        return "redirect:/patient/list";
			return "redirect:/patients/list";
	    }

}