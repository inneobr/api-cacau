package org.inneo.cacau.records;

import org.inneo.cacau.model.Cursos;

public record CursosResponse(String curso, String descricaos) {
	public CursosResponse(Cursos cursos) {
		this(cursos.getCurso(), cursos.getDescricao());
	}
}
