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


@Repository
@EnableTransactionManagement
@Transactional
public class AppointmentTypeDAOImpl implements AppointmentTypeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addAppointmentType(AppointmentType appointmentType) {
        Session session = sessionFactory.getCurrentSession();
        session.save(appointmentType);
    }

    @Override
    public List<AppointmentType> getAllAppointmentTypes() {
        Session session = sessionFactory.getCurrentSession();
        Query<AppointmentType> query = session.createQuery("from AppointmentType", AppointmentType.class);
        List<AppointmentType> appointmentTypes = query.getResultList();
        return appointmentTypes;
    }

    @Override
    public AppointmentType getAppointmentTypeById(int id) {
        Session session = sessionFactory.getCurrentSession();
        AppointmentType appointmentType = session.get(AppointmentType.class, id);
        return appointmentType;
    }
    
    @Override
    public void updateAppointmentType(AppointmentType appointmentType) {
        Session session = sessionFactory.getCurrentSession();
        session.update(appointmentType);
    }

    @Override
    public void deleteAppointmentType(int id) {
        Session session = sessionFactory.getCurrentSession();
        AppointmentType appointmentType = session.get(AppointmentType.class, id);
        session.delete(appointmentType);
    }

}

