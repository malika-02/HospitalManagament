package com.hospital.js.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hospital.models.Doctor;

@Repository
@Transactional
public class DoctorDaoImpl implements DoctorDao {
	@Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveOrUpdateDoctor(Doctor doctor) {
        sessionFactory.getCurrentSession().saveOrUpdate(doctor);
    }
    
    @Override
    public void deleteDoctor(int id) {
        Doctor doctor = getDoctorById(id);
        sessionFactory.getCurrentSession().delete(doctor);
    }

    @Override
    public Doctor getDoctorById(int id) {
        return sessionFactory.getCurrentSession().get(Doctor.class, id);
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return sessionFactory.getCurrentSession().createQuery("from Doctor", Doctor.class).getResultList();
    }
}
