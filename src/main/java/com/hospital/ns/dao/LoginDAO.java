package com.hospital.ns.dao;

import com.hospital.models.Login;

public interface LoginDAO {

	Login validateLogin(String username, String password);

}
