package com.franciscoaguiar.cursomc.resources;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.franciscoaguiar.cursomc.domain.Categoria;
import com.franciscoaguiar.cursomc.services.CategoriaService;

@RestController
@RequestMapping
public class CategoriaResource implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping (value = "/categorias")
	public ResponseEntity<List<Categoria>> findAll(){
		return ResponseEntity.ok().body(categoriaService.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Integer id){
		return ResponseEntity.ok().body(categoriaService.findById(id));
	}
	
}
