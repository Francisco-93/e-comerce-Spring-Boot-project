package com.franciscoaguiar.cursomc.services;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.franciscoaguiar.cursomc.domain.Pedido;
import com.franciscoaguiar.cursomc.repositories.PedidoRepository;
import com.franciscoaguiar.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private PedidoRepository categoriaRepository;
	
	public List<Pedido> findAll(){
		return categoriaRepository.findAll();
	}
	
	public Pedido findById(Integer id){
		Optional<Pedido> obj = categoriaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}
	
	/*public Pedido findById(Integer id){
		Optional<Pedido> obj = categoriaRepository.findById(id);
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName());
		}
		return obj.get();
	}*/

}
