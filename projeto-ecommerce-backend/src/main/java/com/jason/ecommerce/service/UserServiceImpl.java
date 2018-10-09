package com.jason.ecommerce.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jason.ecommerce.model.User;
import com.jason.ecommerce.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public Optional<User> find(Long id) {
		return userRepository.findById(id);
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public User find(String userName) {
		return userRepository.findByUsername(userName);
	}

	@Override
	public void deleteById(long id) {
		userRepository.deleteById(id);
	}
}
