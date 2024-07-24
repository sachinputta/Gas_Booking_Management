package com.demo.main.entity;



import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class User {
	
	@Id
	private long userid;
	private String username;
	private String password;
	private String address;
	private long phoneno;
	private String email;

}
