package com.example.aplicacion.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.aplicacion.model.Rol;

public interface RolRepository extends JpaRepository<Rol, Integer>{
	
}
