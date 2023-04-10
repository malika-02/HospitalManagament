package com.hospital.ns.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hospital.models.Login;
import com.hospital.ns.dao.LoginDAO;

@Controller
public class LoginController {
    
    @Autowired
    private LoginDAO loginDAO;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView showLoginForm() {
        return new ModelAndView("login", "login", new Login());
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView validateLogin(@ModelAttribute("login") Login login, BindingResult result) {
        ModelAndView mav = null;
        Login validLogin = loginDAO.validateLogin(login.getUsername(), login.getPassword());
        if (validLogin != null) {
            mav = new ModelAndView("home");
        } else {
            mav = new ModelAndView("login", "error", "Invalid login credentials");
        }
        return mav;
    }
}
