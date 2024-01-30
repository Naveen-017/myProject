package com.edubridge.app1.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "bookingDetails")
@Data
public class Booking {
	@Id
	@GeneratedValue
	private Integer BookingId;
	private String startDate;
	private String endDate;
	private Double cost;

	//@JsonIgnore
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "CarId")
	private Car car;

	//@JsonIgnore
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "UserId")
	private User user;

}
