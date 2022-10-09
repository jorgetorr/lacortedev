package com.example.aplicacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.aplicacion.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
