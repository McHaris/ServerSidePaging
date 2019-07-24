package com.eksad.ServerSidePaging.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String address;
	
	@Column(nullable = false)
	private String name;
	private Date dob;
	private String phone;
	private Integer age;
	
	@Column(name = "id_pob")
	private String pob;
	
	@Column(name = "id_salary")
	private Integer salary;
	
	@Column(name = "id_division")
	private String division;
	
	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@Column(name = "SEX")
	@Enumerated(EnumType.STRING)
	private Sex sex;

	
	
}
