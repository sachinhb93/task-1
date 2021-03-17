package com.neosoft.task1.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userId;

	@NotBlank(message = "first Name is Mandatory")
	@Size(min = 2, message = "first name should have at least 2 characters")
	private String firstName;

	@NotBlank(message = "surName is Mandatory")
	@Size(min = 2, message = "surname should have at least 2 characters")
	private String surName;

	@Email
	@NotBlank
	private String email;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	@NotBlank
	@Size(min = 8, message = "password should have at least 8 characters")
	private String password;
	@NotBlank
	@Size(min = 10, message = "mobile should have at least 10 digits")
	private String mobile;
	private String address;
	private String city;

	@NotBlank
	@Size(min = 6, message = "pincode should have at least 6 digits")
	private String pincode;

	private LocalDate DOB;
	private LocalDate joiningDate;

	private Boolean deleted;

}
