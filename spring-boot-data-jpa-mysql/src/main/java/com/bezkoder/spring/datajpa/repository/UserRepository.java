package com.bezkoder.spring.datajpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.spring.datajpa.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	List<User> findByPublished(boolean published);
	List<User> findByNameContaining(String Name);
}

