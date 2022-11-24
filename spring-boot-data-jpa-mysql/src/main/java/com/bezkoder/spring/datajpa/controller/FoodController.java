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

import com.bezkoder.spring.datajpa.model.Food;
import com.bezkoder.spring.datajpa.repository.FoodRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class FoodController {

	@Autowired
	FoodRepository foodRepository;

	@GetMapping("/Foods")
	public ResponseEntity<List<Food>> getAllFoods(@RequestParam(required = false) String foodName) {
		try {
			List<Food> tutorials = new ArrayList<Food>();

			if (foodName == null)
            foodRepository.findAll().forEach(tutorials::add);
			else
            foodRepository.findByfoodNameContaining(foodName).forEach(tutorials::add);

			if (tutorials.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(tutorials, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/foods/{id}")
	public ResponseEntity<Food> getFoodById(@PathVariable("id") long id) {
		Optional<Food> foodData = foodRepository.findById(id);

		if (foodData.isPresent()) {
			return new ResponseEntity<>(foodData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/foods")
	public ResponseEntity<Food> createFood(@RequestBody Food food) {
		try {
			Food _food = foodRepository
					.save(new Food(food.getfoodName(), food.getDescription()));
			return new ResponseEntity<>(_food, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/foods/{id}")
	public ResponseEntity<Food> updateFood(@PathVariable("id") long id, @RequestBody Food food) {
		Optional<Food> foodData = foodRepository.findById(id);

		if (foodData.isPresent()) {
			Food _food = foodData.get();
			_food.setfoodName(food.getfoodName());
			_food.setDescription(food.getDescription());
			return new ResponseEntity<>(foodRepository.save(_food), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/foods/{id}")
	public ResponseEntity<HttpStatus> deleteFood(@PathVariable("id") long id) {
		try {
			foodRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/foods")
	public ResponseEntity<HttpStatus> deleteAllFoods() {
		try {
			foodRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}

