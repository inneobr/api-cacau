package org.inneo.cacau.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import lombok.NoArgsConstructor;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "_aulas")
public class Aulas extends GenericEntity{
	private static final long serialVersionUID = 1L;
	
	@Column(name="titulo")
	private String titulo;
	
	@Column(name="descricao")
	private String descricao;
	
	@Column(name="url_video")
	private String urlVideo;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_curso")
	private Cursos curso;
}
