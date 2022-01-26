package com.generation.IntegraJa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.IntegraJa.model.Usuario;
import com.generation.IntegraJa.repository.UsuarioRepository;

/**@author Cesar / Edgar / Pedro Lucas / Edilaine
 * @version v2
 * @since 26/01/2022 
 * */


@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{idUsuario}")
	public ResponseEntity<Usuario> GetById (@PathVariable long idUsuario) {
		return repository.findById(idUsuario).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nomecategoria/{nomecategoria}")
	public ResponseEntity<List<Usuario>> GetByNomeusuario (@PathVariable String nomeusuario) {
		return ResponseEntity.ok(repository.findAllByNomeUsuarioContainingIgnoreCase(nomeusuario));
	}
}
