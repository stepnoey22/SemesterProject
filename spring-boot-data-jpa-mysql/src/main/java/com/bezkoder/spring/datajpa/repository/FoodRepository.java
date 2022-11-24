package com.bezkoder.spring.datajpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.spring.datajpa.model.Food;

public interface FoodRepository extends JpaRepository<Food, Long> {
	List<Food> findByfoodNameContaining(String foodName);
}
