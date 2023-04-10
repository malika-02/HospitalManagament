package com.hospital.ms.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.hospital.models.Doctor;
import com.hospital.models.Patient;

@Repository
@EnableTransactionManagement
@Transactional
public class PatientDaoImpl implements PatientDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Patient> list() {
		// TODO Auto-generated method stub

		Session session = sessionFactory.getCurrentSession();
		Query<Patient> query = session.createQuery("from Patient", Patient.class);
		List<Patient> patients = query.getResultList();
		return patients;

	}
	
    @Override
    public void saveOrUpdatePatient(Patient patient) {
        sessionFactory.getCurrentSession().saveOrUpdate(patient);
    }
    
    @Override
    public void deletePatient(int id) {
        Patient patient = getPatientById(id);
        sessionFactory.getCurrentSession().delete(patient);
    }

    @Override
    public Patient getPatientById(int id) {
        return sessionFactory.getCurrentSession().get(Patient.class, id);
    }

}
