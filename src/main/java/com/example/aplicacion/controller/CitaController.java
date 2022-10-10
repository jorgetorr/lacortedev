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

import com.example.aplicacion.model.Cita;
import com.example.aplicacion.service.CitaService;

@RestController
@RequestMapping("/api/citas")
public class CitaController {
	
	@Autowired
	private CitaService citaService;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Cita cita){
		return ResponseEntity.status(HttpStatus.CREATED).body(citaService.save(cita));
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable Integer id){
		Optional<Cita> cita = citaService.findById(id);
		if(!cita.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		return ResponseEntity.ok(cita);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Cita citaDetalle, @PathVariable Integer id){
		Optional<Cita> cita = citaService.findById(id);
		if(!cita.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		BeanUtils.copyProperties(citaDetalle, cita.get());
		cita.get().setIdcita(id);
		return ResponseEntity.status(HttpStatus.CREATED).body(citaService.save(cita.get()));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id){
		Optional<Cita> cita = citaService.findById(id);
		if(!cita.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		citaService.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public List<Cita> readAll(){
		List<Cita> citas = StreamSupport
				.stream(citaService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return citas;
	}
}
