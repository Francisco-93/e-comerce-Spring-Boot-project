package com.franciscoaguiar.cursomc.services;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.franciscoaguiar.cursomc.domain.Cliente;
import com.franciscoaguiar.cursomc.dto.ClienteDTO;
import com.franciscoaguiar.cursomc.repositories.ClienteRepository;
import com.franciscoaguiar.cursomc.services.exceptions.DataIntegrityException;
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
	
	public Cliente insert (Cliente obj) {
		obj.setId(null);
		return categoriaRepository.save(obj);
	}
	
	public Cliente update (Cliente obj) {
		Cliente newObj = findById(obj.getId());
		updateData(newObj, obj);
		return categoriaRepository.save(newObj);
	}
	
	public void deleteById(Integer id) {
		findById(id);
		try {
			categoriaRepository.deleteById(id);			
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir um cliente que possui pedidos");
		}
	}
	
	public Page<Cliente> findPage(Integer page, Integer linesPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPage, Direction.valueOf(direction), orderBy);
		return categoriaRepository.findAll(pageRequest);
	}
	
	public Cliente fromDTO(ClienteDTO objDTO) {
		return new Cliente(objDTO.getId(), objDTO.getNome(), objDTO.getEmail(), null, null);
	}
	
	private void updateData (Cliente newObj, Cliente obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
	}

}
