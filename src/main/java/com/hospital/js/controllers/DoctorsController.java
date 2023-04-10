package com.hospital.js.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hospital.js.dao.DoctorDao;
import com.hospital.models.Doctor;

@Controller
@RequestMapping("/doctors")
public class DoctorsController {
	@Autowired
    private DoctorDao doctorDao;

    @GetMapping("/list")
    public String listDoctors(Model model) {
        List<Doctor> doctors = doctorDao.getAllDoctors();
        model.addAttribute("doctors", doctors);
        return "list-doctors";
    }

    @GetMapping("/add")
    public String add(Model model) {
        Doctor doctor = new Doctor();
        model.addAttribute("doctor", doctor);
        return "doctor-form";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam("id") int id, Model model) {
        Doctor doctor = doctorDao.getDoctorById(id);
        model.addAttribute("doctor", doctor);
        return "doctor-form";
    }

    @PostMapping("/saveOrUpdateDoctor")
    public String saveOrUpdateDoctor(@ModelAttribute("doctor") Doctor doctor) {
        doctorDao.saveOrUpdateDoctor(doctor);
        return "redirect:/doctors/list";
    }

//    @PostMapping("/updateDoctor")
//    public String updateDoctor(@ModelAttribute("doctor") Doctor doctor) {
//        doctorDao.updateDoctor(doctor);
//        return "redirect:/doctor/list";
//    }

    @GetMapping("/delete")
    public String deleteDoctor(@RequestParam("id") int id) {
    	System.out.println(id);
		Doctor doctor = doctorDao.getDoctorById(id);
		System.out.println(doctor.getSpecialization());
        doctorDao.deleteDoctor(id);
        return "redirect:/doctors/list";
    }
}
