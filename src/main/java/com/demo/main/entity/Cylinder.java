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
public class Cylinder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long cylinderid;
	private String cylinderagency;
	private String type;
	private float weight;
	private String strapcolor;
	private float price;

}
