package com.hospital.ns.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.hospital.models.Patient;

@Repository
@EnableTransactionManagement
@Transactional
public class PatientDAOImpl implements PatientDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addPatient(Patient patient) {
        Session session = sessionFactory.getCurrentSession();
        session.save(patient);
    }

    @Override
    public List<Patient> getAllPatients() {
        Session session = sessionFactory.getCurrentSession();
        Query<Patient> query = session.createQuery("from Patient", Patient.class);
        List<Patient> patients = query.getResultList();
        return patients;
    }

    @Override
    public Patient getPatientById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Patient patient = session.get(Patient.class, id);
        return patient;
    }

    @Override
    public void updatePatient(Patient patient) {
        Session session = sessionFactory.getCurrentSession();
        session.update(patient);
    }

    @Override
    public void deletePatient(int id) {
        Session session = sessionFactory.getCurrentSession();
        Patient patient = session.get(Patient.class, id);
        session.delete(patient);
    }
}

