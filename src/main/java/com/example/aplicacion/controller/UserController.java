package com.example.aplicacion.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.aplicacion.model.User;

@RestController
@RequestMapping("/user")
public class UserController {
	@GetMapping
	public ResponseEntity<?> consultaUsuarios(){
		return ResponseEntity.ok("Consulta Usuarios");
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> consultaUsuario(@PathVariable Long id){
		return  ResponseEntity.ok("Consulta de un Usuario " + id);
	}
	@PostMapping
	public ResponseEntity<?> crearUsuario(@RequestBody User user){
		return ResponseEntity.ok(user);
	}
	@PutMapping("/{id}")
	public ResponseEntity<?> actualizaUsuario(@RequestBody User user,  @PathVariable Long id){
		return ResponseEntity.ok("Actualiza Usuarios "+ id);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarUsuario(@PathVariable Long id){
		return ResponseEntity.ok("Elimina Usuarios "+ id);
	
	}
	

}
