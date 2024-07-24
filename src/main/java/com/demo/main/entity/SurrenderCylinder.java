package com.demo.main.entity;

import java.time.LocalDate;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SurrenderCylinder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long surrenderid;
	private LocalDate surrenderdate;
	
	@OneToOne
	private Cylinder cylinder;
	
	@OneToOne
	private Customer customer;

}
