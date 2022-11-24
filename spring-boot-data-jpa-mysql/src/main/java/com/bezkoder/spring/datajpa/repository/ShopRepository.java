package com.bezkoder.spring.datajpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.spring.datajpa.model.Shop;

public interface ShopRepository extends JpaRepository<Shop, Long> {
	List<Shop> findByshopNameContaining(String shopName);
}
