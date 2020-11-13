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

import com.franciscoaguiar.cursomc.domain.Categoria;
import com.franciscoaguiar.cursomc.dto.CategoriaDTO;
import com.franciscoaguiar.cursomc.repositories.CategoriaRepository;
import com.franciscoaguiar.cursomc.services.exceptions.DataIntegrityException;
import com.franciscoaguiar.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public List<Categoria> findAll(){
		return categoriaRepository.findAll();
	}
	
	public Categoria findById(Integer id){
		Optional<Categoria> obj = categoriaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
	
	/*public Categoria findById(Integer id){
		Optional<Categoria> obj = categoriaRepository.findById(id);
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName());
		}
		return obj.get();
	}*/
	
	
	public Categoria insert (Categoria obj) {
		obj.setId(null);
		return categoriaRepository.save(obj);
	}
	
	public Categoria update (Categoria obj) {
		findById(obj.getId());
		return categoriaRepository.save(obj);
	}
	
	public void deleteById(Integer id) {
		findById(id);
		try {
			categoriaRepository.deleteById(id);			
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos");
		}
	}
	
	public Page<Categoria> findPage(Integer page, Integer linesPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPage, Direction.valueOf(direction), orderBy);
		return categoriaRepository.findAll(pageRequest);
	}
	
	public Categoria fromDTO(CategoriaDTO objDTO) {
		return new Categoria(objDTO.getId(), objDTO.getNome());
	}
	
}
