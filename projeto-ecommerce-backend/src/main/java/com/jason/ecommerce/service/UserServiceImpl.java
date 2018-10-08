package com.jason.ecommerce.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jason.ecommerce.exception.ResourceNotFoundException;
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
	public User getUser(long id) {
		return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuário inexistente!"));
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public void deleteById(long id) {
		userRepository.deleteById(id);
	}
}
