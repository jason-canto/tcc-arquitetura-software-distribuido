package com.jason.ecommerce.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/api/admin")
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users = new ArrayList<>();
		service.getAllUsers().forEach(users::add);
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	@PostMapping("/users")
	public ResponseEntity<User> createUser(@RequestBody User user) {;
		User userReturned = service.save(user);
		return new ResponseEntity<>(userReturned, HttpStatus.CREATED);
	}

	@DeleteMapping("/users/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Long id) {
		service.deleteById(id);
		return new ResponseEntity<>("Cliente removido com sucesso!", HttpStatus.OK);
	}

	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User customer) {
		if (service.getUser(id) != null) {
			return new ResponseEntity<>(service.save(customer), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id) {
		return new ResponseEntity<>(service.getUser(id), HttpStatus.OK);
	}
}
