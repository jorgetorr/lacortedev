package com.example.aplicacion.service;

import com.example.aplicacion.model.User;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
	public List<User> findAll();
	public Page<User> findAll(Pageable paginable);
	public Optional<User> findById(Integer id);
	public User save(User user);
	public void deleteById(Integer id);
	
}
