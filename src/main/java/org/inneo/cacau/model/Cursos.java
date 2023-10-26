package org.inneo.cacau.model;

import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.Collection;

import lombok.NoArgsConstructor;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotBlank;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "_cursos")
public class Cursos extends GenericEntity {
	private static final long serialVersionUID = 1L;

	@NotBlank
	@Column(name="title")
	private String title;
	
	@NotBlank
	@Column(name="descricao")
	private String descricao;
	
	@Transient
	private Collection<Aulas> aulas = new ArrayList<Aulas>();
}
	
