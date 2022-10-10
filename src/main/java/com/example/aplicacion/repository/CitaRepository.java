package com.example.aplicacion.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.aplicacion.model.Cita;

public interface CitaRepository extends JpaRepository<Cita, Integer>{
	
}
