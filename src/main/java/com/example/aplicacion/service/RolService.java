package com.example.aplicacion.service;

import com.example.aplicacion.model.Rol;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RolService {
	public List<Rol> findAll();
	public Page<Rol> findAll(Pageable paginable);
	public Optional<Rol> findById(Integer id);
	public Rol save(Rol rol);
	public void deleteById(Integer id);
	
}
