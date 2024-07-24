package com.demo.main.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GasBookings {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long gasbookingid;
	private LocalDate bookingdate;
	private boolean status;
	private float bill;
	
	@ManyToOne
	@JsonBackReference
	private Customer customer;
	
}
