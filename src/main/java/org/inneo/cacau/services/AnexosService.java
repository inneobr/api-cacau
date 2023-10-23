package org.inneo.cacau.services;

import java.util.UUID;
import java.io.IOException;
import org.inneo.cacau.model.Cursos;

import lombok.RequiredArgsConstructor;
import org.inneo.cacau.repository.CursosRep;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class AnexosService {
	private final CursosRep cursosRep;

	public Cursos save(UUID uuid, MultipartFile anexo) {		
		try {
			Cursos curso = cursosRep.findByUuid(uuid);
			curso.setThumbnail(anexo.getBytes());		
			return cursosRep.save(curso);	
		} catch (IOException e) {
			throw new  NullPointerException(e.getMessage());
		}	
	}
}
