package org.inneo.cacau.repository;

import java.util.UUID;

import org.inneo.cacau.model.Eventos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EventosRep extends JpaRepository<Eventos, UUID>, JpaSpecificationExecutor<Eventos>  {

}
