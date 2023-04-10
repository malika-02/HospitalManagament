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

import com.hospital.models.Patient;
import com.hospital.ns.dao.PatientDAO;


@Controller
public class PatientController {

    @Autowired
    private PatientDAO patientDAO;

    @RequestMapping(value = "/patient/add", method = RequestMethod.GET)
    public ModelAndView addPatientForm() {
        return new ModelAndView("addPatient", "patient", new Patient());
    }

    @RequestMapping(value = "/patient/add", method = RequestMethod.POST)
    public ModelAndView addPatient(@ModelAttribute("patient") Patient patient, BindingResult result) {
        patientDAO.addPatient(patient);
        return new ModelAndView("redirect:/patient/list");
    }

    @RequestMapping(value = "/patient/list", method = RequestMethod.GET)
    public ModelAndView listPatients() {
        List<Patient> patients = patientDAO.getAllPatients();
        return new ModelAndView("patientList", "patients", patients);
    }

    @RequestMapping(value = "/patient/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editPatientForm(@PathVariable("id") int id) {
        Patient patient = patientDAO.getPatientById(id);
        return new ModelAndView("editPatient", "patient", patient);
    }

    @RequestMapping(value = "/patient/edit/{id}", method = RequestMethod.POST)
    public ModelAndView editPatient(@ModelAttribute("patient") Patient patient, BindingResult result) {
        patientDAO.updatePatient(patient);
        return new ModelAndView("redirect:/patient/list");
    }

    @RequestMapping(value = "/patient/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deletePatient(@PathVariable("id") int id) {
        patientDAO.deletePatient(id);
        return new ModelAndView("redirect:/patient/list");
    }
}

