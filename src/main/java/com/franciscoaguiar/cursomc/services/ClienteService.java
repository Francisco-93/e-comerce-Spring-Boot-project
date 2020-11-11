package com.franciscoaguiar.cursomc.services;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.franciscoaguiar.cursomc.domain.Cliente;
import com.franciscoaguiar.cursomc.repositories.ClienteRepository;
import com.franciscoaguiar.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ClienteRepository categoriaRepository;
	
	public List<Cliente> findAll(){
		return categoriaRepository.findAll();
	}
	
	public Cliente findById(Integer id){
		Optional<Cliente> obj = categoriaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}
	
	/*public Cliente findById(Integer id){
		Optional<Cliente> obj = categoriaRepository.findById(id);
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName());
		}
		return obj.get();
	}*/

}
