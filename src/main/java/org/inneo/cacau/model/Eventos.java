package org.inneo.cacau.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;
import lombok.Getter;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "_eventos")
public class Eventos extends GenericEntity{
	private static final long serialVersionUID = 1L;
	
	@Column(name="local")
	private String localizacao;
	
	@Column(name="endereco")
	private String endereco;
	
	@Column(name="data")
	private Integer dia;
	
	@Column(name="mes")
	private String mes;
	
	@Column(name="cidade")
	private String cidade;

}
