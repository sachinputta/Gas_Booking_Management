package com.demo.main.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bank {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long bankid;
	private String bankname;
	private String address;
	

}
