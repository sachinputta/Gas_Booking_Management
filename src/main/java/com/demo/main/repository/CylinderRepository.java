package com.demo.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.main.entity.Cylinder;

@Repository
public interface CylinderRepository extends JpaRepository<Cylinder, Long> {

	List<Cylinder> findByType(String type);

}
