package com.example.aplicacion.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.aplicacion.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
}
