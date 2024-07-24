package com.demo.main.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends User {
	
	@OneToOne
	private Cylinder cylinder;
	
	@OneToOne 
	private Bank bank;
	
	private long accountnumber;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,
			mappedBy = "customer")
	@JsonManagedReference
	List<GasBookings> gasbookings;

}


