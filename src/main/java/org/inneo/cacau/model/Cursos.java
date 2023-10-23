package org.inneo.cacau.model;

import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.Lob;
import lombok.NoArgsConstructor;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.FetchType;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Transient;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import org.apache.tomcat.util.codec.binary.Base64;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "_cursos")
public class Cursos extends GenericEntity {
	private static final long serialVersionUID = 1L;

	@NotBlank
	@Column(name="curso")
	private String curso;
	
	@NotBlank
	@Column(name="descricao")
	private String descricao;
	
	@Lob
	@Column(name="thumbnail")
	private byte[] thumbnail;
	
	@Transient
	public String thumbnail() {
		return Base64.encodeBase64String(thumbnail);
	}
	
	@JoinTable( name = "aulas_curso")
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Aulas> aulas = new ArrayList<>();
}
	
