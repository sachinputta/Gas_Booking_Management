package com.demo.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.main.entity.SurrenderCylinder;

@Repository
public interface SurrenderCylinderRepository extends JpaRepository<SurrenderCylinder, Long> {

	@Query("SELECT COUNT(sc) FROM SurrenderCylinder sc")
	long countSurrenderedCylinders();

}
