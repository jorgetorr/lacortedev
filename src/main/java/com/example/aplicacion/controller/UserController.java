package com.example.aplicacion.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.BeanUtils;
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

import com.example.aplicacion.model.User;
import com.example.aplicacion.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody User user){
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable Integer id){
		Optional<User> user = userService.findById(id);
		if(!user.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		return ResponseEntity.ok(user);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody User userDetalle, @PathVariable Integer id){
		Optional<User> user = userService.findById(id);
		if(!user.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		BeanUtils.copyProperties(userDetalle, user.get());
		user.get().setIduser(id);
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user.get()));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id){
		Optional<User> user = userService.findById(id);
		if(!user.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		userService.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public List<User> readAll(){
		List<User> users= StreamSupport
				.stream(userService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return users;
	}
}
