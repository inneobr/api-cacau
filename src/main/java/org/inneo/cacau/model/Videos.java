package org.inneo.cacau.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "_videos")
public class Videos extends GenericEntity{
	private static final long serialVersionUID = 1L;
	
	@Column(name="titulo")
	private String titulo;
	
	@Column(name="descricao")
	private String descricao;
	
	@Column(name="url")
	private String path;
}
