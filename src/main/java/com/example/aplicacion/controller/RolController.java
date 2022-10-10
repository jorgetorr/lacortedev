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

import com.example.aplicacion.model.Rol;
import com.example.aplicacion.service.RolService;

@RestController
@RequestMapping("/api/roles")
public class RolController {
	
	@Autowired
	private RolService rolService;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Rol rol){
		return ResponseEntity.status(HttpStatus.CREATED).body(rolService.save(rol));
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable Integer id){
		Optional<Rol> rol = rolService.findById(id);
		if(!rol.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		return ResponseEntity.ok(rol);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Rol rolDetalle, @PathVariable Integer id){
		Optional<Rol> rol = rolService.findById(id);
		if(!rol.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		BeanUtils.copyProperties(rolDetalle, rol.get());
		rol.get().setIdrol(id);
		return ResponseEntity.status(HttpStatus.CREATED).body(rolService.save(rol.get()));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id){
		Optional<Rol> rol = rolService.findById(id);
		if(!rol.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		rolService.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public List<Rol> readAll(){
		List<Rol> roles = StreamSupport
				.stream(rolService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return roles;
	}
}
