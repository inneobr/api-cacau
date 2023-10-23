package org.inneo.cacau.repository;

import java.util.UUID;
import org.inneo.cacau.model.Videos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VideosRep extends JpaRepository<Videos, UUID>, JpaSpecificationExecutor<Videos>  {
	Videos findByUuid(UUID uuid);
}
