package com.franciscoaguiar.cursomc.resources;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.franciscoaguiar.cursomc.domain.Pedido;
import com.franciscoaguiar.cursomc.services.PedidoService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private PedidoService categoriaService;
	
	@GetMapping
	public ResponseEntity<List<Pedido>> findAll(){
		return ResponseEntity.ok().body(categoriaService.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Pedido> findById(@PathVariable Integer id){
		Pedido obj = categoriaService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
