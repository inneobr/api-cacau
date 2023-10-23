package org.inneo.cacau.repository;

import java.util.UUID;
import org.inneo.cacau.model.Cursos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CursosRep extends JpaRepository<Cursos, UUID>, JpaSpecificationExecutor<Cursos>  {
	Cursos findByUuid(UUID uuid);
}
