package com.hospital.ns.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.hospital.models.Doctor;



@Repository
@EnableTransactionManagement
@Transactional
public class DoctorDAOImpl implements DoctorDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addDoctor(Doctor doctor) {
        Session session = sessionFactory.getCurrentSession();
        session.save(doctor);
    }

    @Override
    public List<Doctor> getAllDoctors() {
        Session session = sessionFactory.getCurrentSession();
        Query<Doctor> query = session.createQuery("from Doctor", Doctor.class);
        List<Doctor> doctors = query.getResultList();
        return doctors;
    }

    @Override
    public Doctor getDoctorById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Doctor doctor = session.get(Doctor.class, id);
        return doctor;
    }

    @Override
    public void updateDoctor(Doctor doctor) {
        Session session = sessionFactory.getCurrentSession();
        session.update(doctor);
    }

    @Override
    public void deleteDoctor(int id) {
        Session session = sessionFactory.getCurrentSession();
        Doctor doctor = session.get(Doctor.class, id);
        session.delete(doctor);
    }
}

