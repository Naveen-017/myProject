package com.edubridge.app1.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "paymentDetails")
@Data
public class Payment {
	@Id
	@GeneratedValue
	private long id;
	private String cardholder_name;
	private String card_number;
	private Date expiry_date;

	private String upi;

}
