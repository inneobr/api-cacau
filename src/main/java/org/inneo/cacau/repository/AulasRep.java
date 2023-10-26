package org.inneo.cacau.repository;

import java.util.List;
import java.util.UUID;
import org.inneo.cacau.model.Aulas;
import org.inneo.cacau.model.Cursos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AulasRep extends JpaRepository<Aulas, UUID>{
	Aulas findByUuid(UUID uuid);
	List<Aulas> findByCurso(Cursos curso);
}
