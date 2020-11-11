package com.franciscoaguiar.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.franciscoaguiar.cursomc.domain.enums.TipoCliente;

public class Cliente implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private String email;
	private String cpfPuCnpj;
	private Integer tipo;
	
	private List<Endereco> enderecos = new ArrayList<>();
	
	private Set<String> telefones = new HashSet<>();
	
	public Cliente() {
	}

	public Cliente(Integer id, String nome, String email, String cpfPuCnpj, TipoCliente tipo) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpfPuCnpj = cpfPuCnpj;
		this.tipo = tipo.getI();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpfPuCnpj() {
		return cpfPuCnpj;
	}

	public void setCpfPuCnpj(String cpfPuCnpj) {
		this.cpfPuCnpj = cpfPuCnpj;
	}

	public TipoCliente getTipoCliente() {
		return TipoCliente.toEnum(tipo);
	}

	public void setTipoCliente(TipoCliente tipo) {
		this.tipo = tipo.getI();
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public Set<String> getTelefones() {
		return telefones;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
