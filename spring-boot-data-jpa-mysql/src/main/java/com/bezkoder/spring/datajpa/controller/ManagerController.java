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

import com.bezkoder.spring.datajpa.model.Manager;
import com.bezkoder.spring.datajpa.repository.ManagerRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ManagerController {

	@Autowired
	ManagerRepository managerRepository;

	@GetMapping("/managers")
	public ResponseEntity<List<Manager>> getAllManagers(@RequestParam(required = false) String name) {
		try {
			List<Manager> managers = new ArrayList<Manager>();

			if (name == null)
            managerRepository.findAll().forEach(managers::add);
			else
            managerRepository.findByNameContaining(name).forEach(managers::add);

			if (managers.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(managers, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/managers/{id}")
	public ResponseEntity<Manager> getManagerById(@PathVariable("id") long id) {
		Optional<Manager> managerData = managerRepository.findById(id);

		if (managerData.isPresent()) {
			return new ResponseEntity<>(managerData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/managers")
	public ResponseEntity<Manager> createManager(@RequestBody Manager manager) {
		try {
			Manager _manager = managerRepository
					.save(new Manager(manager.getName(), manager.getLastname()));
			return new ResponseEntity<>(_manager, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

