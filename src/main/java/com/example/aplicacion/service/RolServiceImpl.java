package com.example.aplicacion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.aplicacion.model.Rol;
import com.example.aplicacion.repository.RolRepository;

@Service
public class RolServiceImpl implements RolService {
	
	@Autowired
	private RolRepository rolRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Rol> findAll() {
		return rolRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Rol> findAll(Pageable paginable) {
		return rolRepository.findAll(paginable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Rol> findById(Integer id) {
		return rolRepository.findById(id);
	}

	@Override
	@Transactional
	public Rol save(Rol rol) {
		return rolRepository.save(rol);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		rolRepository.deleteById(id);
	}

}
