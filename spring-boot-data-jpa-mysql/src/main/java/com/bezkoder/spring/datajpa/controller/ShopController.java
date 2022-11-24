package com.bezkoder.spring.datajpa.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.spring.datajpa.model.Shop;
import com.bezkoder.spring.datajpa.repository.ShopRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ShopController {

	@Autowired
	ShopRepository shopRepository;

	@GetMapping("/shops")
	public ResponseEntity<List<Shop>> getAllShops(@RequestParam(required = false) String shopName) {
		try {
			List<Shop> tutorials = new ArrayList<Shop>();

			if (shopName == null)
            shopRepository.findAll().forEach(tutorials::add);
			else
            shopRepository.findByshopNameContaining(shopName).forEach(tutorials::add);

			if (tutorials.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(tutorials, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/shops/{id}")
	public ResponseEntity<Shop> getShopById(@PathVariable("id") long id) {
		Optional<Shop> shopData = shopRepository.findById(id);

		if (shopData.isPresent()) {
			return new ResponseEntity<>(shopData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/shops")
	public ResponseEntity<Shop> createShop(@RequestBody Shop shop) {
		try {
			Shop _shop = shopRepository
					.save(new Shop(shop.getshopName(), shop.getDescription()));
			return new ResponseEntity<>(_shop, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/shops/{id}")
	public ResponseEntity<Shop> updateShop(@PathVariable("id") long id, @RequestBody Shop shop) {
		Optional<Shop> shopData = shopRepository.findById(id);

		if (shopData.isPresent()) {
			Shop _shop = shopData.get();
			_shop.setshopName(shop.getshopName());
			_shop.setDescription(shop.getDescription());
			return new ResponseEntity<>(shopRepository.save(_shop), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/shops/{id}")
	public ResponseEntity<HttpStatus> deleteShop(@PathVariable("id") long id) {
		try {
			shopRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/shops")
	public ResponseEntity<HttpStatus> deleteAllShops() {
		try {
			shopRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}