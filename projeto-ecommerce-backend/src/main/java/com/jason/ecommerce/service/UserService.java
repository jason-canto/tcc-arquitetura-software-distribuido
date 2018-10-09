package com.jason.ecommerce.service;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import com.jason.ecommerce.model.User;

public interface UserService {

	@NotNull
	Iterable<User> getAllUsers();

	User save(User user);

	void deleteById(long id);

	User find(String userName);

	Optional<User> find(Long id);
	
}
