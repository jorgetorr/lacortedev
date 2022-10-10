package com.example.aplicacion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.aplicacion.model.Cita;
import com.example.aplicacion.repository.CitaRepository;

@Service
public class CitaServiceImpl implements CitaService {
	
	@Autowired
	private CitaRepository citaRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Cita> findAll() {
		return citaRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Cita> findAll(Pageable paginable) {
		return citaRepository.findAll(paginable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Cita> findById(Integer id) {
		return citaRepository.findById(id);
	}

	@Override
	@Transactional
	public Cita save(Cita cita) {
		return citaRepository.save(cita);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		citaRepository.deleteById(id);
	}

}
