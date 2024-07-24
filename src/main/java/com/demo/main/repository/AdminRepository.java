package com.demo.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.main.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {



}
