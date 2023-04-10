package com.hospital.ns.dao;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.hospital.models.AppointmentType;
import com.hospital.models.Doctor;
import com.hospital.models.Registration;


@Repository
@EnableTransactionManagement
@Transactional
public class RegistrationDAOImpl implements RegistrationDAO {

	    @Autowired
	    private SessionFactory sessionFactory;

	    @Override
	    public void addRegistration(Registration registration) {
	        Session session = sessionFactory.getCurrentSession();
	        session.save(registration);
	    }

	    @Override
	    public void updateRegistration(Registration registration) {
	        Session session = sessionFactory.getCurrentSession();
	        session.update(registration);
	    }

	    @Override
	    public void deleteRegistration(int id) {
	        Session session = sessionFactory.getCurrentSession();
	        Registration registration = session.get(Registration.class, id);
	        if (registration != null) {
	            session.delete(registration);
	        }
	    }

	    @Override
	    public Registration getRegistrationById(int id) {
	        Session session = sessionFactory.getCurrentSession();
	        return session.get(Registration.class, id);
	    }

	    @Override
	    public List<Registration> getAllRegistrations() {
	        Session session = sessionFactory.getCurrentSession();
	        return session.createQuery("FROM Registration", Registration.class).getResultList();
	    }
	}

