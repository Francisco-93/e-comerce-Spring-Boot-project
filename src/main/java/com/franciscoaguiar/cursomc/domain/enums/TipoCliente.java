package com.franciscoaguiar.cursomc.domain.enums;

public enum TipoCliente {
	
	PESSOA_FISICA(1, "Pessoa Física"),
	PESSOA_JURIDICA(2, "Pessoa Jurídica");

	private Integer i;
	private String nome;
	
	private TipoCliente(Integer i, String nome) {
		this.i = i;
		this.nome = nome;
	}

	public Integer getI() {
		return i;
	}

	public String getNome() {
		return nome;
	}
	
	public static TipoCliente toEnum(Integer i) {
		if(i == null) {
			return null;
		}
		for (TipoCliente type : TipoCliente.values()) {
			if(i.equals(type.getI())) {
				return type;
			}
		}
		throw new IllegalArgumentException("Id inválido: " + i);
	}
	
}
