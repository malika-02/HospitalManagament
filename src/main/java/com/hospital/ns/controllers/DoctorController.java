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

import com.hospital.models.Doctor;
import com.hospital.ns.dao.DoctorDAO;

@Controller
public class DoctorController {

    @Autowired
    private DoctorDAO doctorDAO;

    @RequestMapping(value = "/doctor/add", method = RequestMethod.GET)
    public ModelAndView addDoctorForm() {
        return new ModelAndView("addDoctor", "doctor", new Doctor());
    }

    @RequestMapping(value = "/doctor/add", method = RequestMethod.POST)
    public ModelAndView addDoctor(@ModelAttribute("doctor") Doctor doctor, BindingResult result) {
        doctorDAO.addDoctor(doctor);
        return new ModelAndView("redirect:/doctor/list");
    }

    @RequestMapping(value = "/doctor/list", method = RequestMethod.GET)
    public ModelAndView listDoctors() {
        List<Doctor> doctors = doctorDAO.getAllDoctors();
        return new ModelAndView("doctorList", "doctors", doctors);
    }

    @RequestMapping(value = "/doctor/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editDoctorForm(@PathVariable("id") int id) {
        Doctor doctor = doctorDAO.getDoctorById(id);
        return new ModelAndView("editDoctor", "doctor", doctor);
    }
    
    
    @RequestMapping(value = "/doctor/edit/{id}", method = RequestMethod.POST)
    public ModelAndView editDoctor(@ModelAttribute("doctor") Doctor doctor, BindingResult result) {
        doctorDAO.updateDoctor(doctor);
        return new ModelAndView("redirect:/doctor/list");
    }

    @RequestMapping(value = "/doctor/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteDoctor(@PathVariable("id") int id) {
        doctorDAO.deleteDoctor(id);
        return new ModelAndView("redirect:/doctor/list");
    }
}

