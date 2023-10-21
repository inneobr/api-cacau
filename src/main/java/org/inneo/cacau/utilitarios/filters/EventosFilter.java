package org.inneo.cacau.utilitarios.filters;

import lombok.Data;

@Data
public class EventosFilter {
	private String localizacao;	
	private String endereco;
	private Integer dia;
	private String mes;
	private String cidade;
}
