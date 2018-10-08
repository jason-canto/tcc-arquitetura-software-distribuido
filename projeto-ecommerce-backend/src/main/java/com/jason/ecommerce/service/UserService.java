package com.jason.ecommerce.service;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.jason.ecommerce.model.User;

@Validated
public interface UserService {

	@NotNull
	Iterable<User> getAllUsers();

	User getUser(long id);

	User save(User user);

	void deleteById(long id);
}
