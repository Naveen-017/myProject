package com.edubridge.app1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="adminDetails")
@Data
public class Admin {
	@Id
	@GeneratedValue
	private Integer adminId;
	private String email;
	private String password;

}
