package com.edubridge.app1.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;

import jakarta.persistence.Id;

import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "userDetails")
@Data
public class User {
	
@Id
@GeneratedValue
private Integer UserId;
private String firstName;
private String lastName;
private String gender;
private String address;
private Long mobileNumber;
private String email;
private String password;


}
