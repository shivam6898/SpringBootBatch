package com.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@AllArgsConstructor
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	
	private Integer empId;
	private String empName;
	private double empSal;
	
	
	/*
	 * public Employee(String empName, double empSal) { super(); this.empName =
	 * empName; this.empSal = empSal; }
	 * 
	 */
}
