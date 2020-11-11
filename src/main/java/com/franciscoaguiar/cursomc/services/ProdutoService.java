package com.franciscoaguiar.cursomc.services;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.franciscoaguiar.cursomc.domain.Produto;
import com.franciscoaguiar.cursomc.repositories.ProdutoRepository;
import com.franciscoaguiar.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public List<Produto> findAll(){
		return produtoRepository.findAll();
	}
	
	public Produto findById(Integer id){
		Optional<Produto> obj = produtoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()));
	}
	
	/*public Produto findById(Integer id){
		Optional<Produto> obj = produtoRepository.findById(id);
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName());
		}
		return obj.get();
	}*/

}
