package com.franciscoaguiar.cursomc.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.franciscoaguiar.cursomc.domain.Categoria;
import com.franciscoaguiar.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public List<Categoria> findAll(){
		return categoriaRepository.findAll();
	}
	
	public Categoria findById(Integer id){
		Categoria obj = categoriaRepository.findById(id).get();
		return obj;
	}

}
