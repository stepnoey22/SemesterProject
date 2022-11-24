package com.bezkoder.spring.datajpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.spring.datajpa.model.Manager;

public interface ManagerRepository extends JpaRepository<Manager, Long> {
	List<Manager> findByNameContaining(String Name);
}
