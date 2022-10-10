package com.example.aplicacion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.aplicacion.model.User;
import com.example.aplicacion.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional(readOnly = true)
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<User> findAll(Pageable paginable) {
		return userRepository.findAll(paginable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<User> findById(Integer id) {
		return userRepository.findById(id);
	}

	@Override
	@Transactional
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		userRepository.deleteById(id);
	}

}
