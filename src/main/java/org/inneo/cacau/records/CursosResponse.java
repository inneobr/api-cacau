package org.inneo.cacau.records;

import java.util.UUID;
import java.util.Collection;
import org.inneo.cacau.model.Aulas;
import org.inneo.cacau.model.Cursos;

public record CursosResponse(UUID uuid, String title, String descricaos,  Collection<Aulas> aulas) {
	public CursosResponse(Cursos cursos) {
		this(cursos.getUuid(), cursos.getTitle(), cursos.getDescricao(), cursos.getAulas());
	}
}
 