package com.edubridge.app1.model;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "carDetails")
@Data
public class Car {
	@Id
	@GeneratedValue
	private Integer CarId;
	private String numberPlate;
	
	//@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "categoryId")
	private CarCategory carCategory;

	private String model;
	private String color;
	private Integer year;
	private String imageUrl;
	private Integer capacity;
	private Double price_per_day;
	private String availablestatus;
}
