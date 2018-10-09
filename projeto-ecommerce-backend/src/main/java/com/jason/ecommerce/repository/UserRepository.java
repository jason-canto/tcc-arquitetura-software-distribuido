package com.jason.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;

import com.jason.ecommerce.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

	User findByUsername(String userName);

}
