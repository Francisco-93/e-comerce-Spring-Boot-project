package com.franciscoaguiar.cursomc.domain.enums;

public enum EstadoPagamento {
	
	PENDENTE (1, "Pendente"),
	QUITADO (2, "Quitado"), 
	CANCELADO (3, "Cancelado");

	private Integer cod;
	private String tipo;
	
	private EstadoPagamento(Integer cod, String tipo) {
		this.cod=cod;
		this.tipo=tipo;
	}

	public Integer getCod() {
		return cod;
	}

	public String getTipo() {
		return tipo;
	}
	
	public static EstadoPagamento toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for (EstadoPagamento type : EstadoPagamento.values()) {
			if(cod.equals(type.getCod())) {
				return type;
			}
		}
		throw new IllegalArgumentException("Id inválido: " + cod);
	}

}
