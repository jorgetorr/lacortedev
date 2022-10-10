package com.example.aplicacion.service;

import com.example.aplicacion.model.Cita;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CitaService {
	public List<Cita> findAll();
	public Page<Cita> findAll(Pageable paginable);
	public Optional<Cita> findById(Integer id);
	public Cita save(Cita cita);
	public void deleteById(Integer id);
	
}
