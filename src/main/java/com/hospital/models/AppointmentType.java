package com.hospital.models;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "appointment_type")
public class AppointmentType implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    // Getters and Setters
    
    
}