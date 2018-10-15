package com.jason.ecommerce.controller;

import java.util.ArrayList;
import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.jason.ecommerce.model.User;
import com.jason.ecommerce.service.UserService;

@RestController
@RequestMapping("/admin")
public class UserController {

	@Autowired
	private UserService service;

	@CrossOrigin
	@GetMapping("/users")
	public ResponseEntity<List<User>> getUsers() {
		List<User> users = new ArrayList<>();
		service.findAll().forEach(users::add);
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@CrossOrigin
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User userReturned = service.save(user);
		return new ResponseEntity<>(userReturned, HttpStatus.CREATED);
	}

	@CrossOrigin
	@DeleteMapping("/users/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
		service.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@CrossOrigin
	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User customer) {
		return new ResponseEntity<>(service.save(customer), HttpStatus.OK);
	}

	@CrossOrigin
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id) {
		return new ResponseEntity<>(service.find(id), HttpStatus.OK);
	}
}
