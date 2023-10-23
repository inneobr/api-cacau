package org.inneo.cacau.services;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import java.io.IOException;
import org.inneo.cacau.model.Cursos;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.inneo.cacau.repository.CursosRep;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.inneo.cacau.utilitarios.enums.Situacao;
import org.inneo.cacau.utilitarios.specs.CursoSpec;
import org.inneo.cacau.utilitarios.filters.CursosFilter;

@Service
@RequiredArgsConstructor
public class CursosService {	
	private final CursosRep cursosRep;
	
	public Cursos save(Cursos request) {		
		Cursos curso = request.getUuid() != null ? cursosRep.getReferenceById(request.getUuid()) : new Cursos();
		request.setCreatedAt(curso.getCreatedAt());
		BeanUtils.copyProperties(request, curso);
		return cursosRep.save(curso);		
	}	
	
	public Cursos thumbnail(UUID uuid, MultipartFile anexo) {		
		try {
			Cursos curso = cursosRep.findByUuid(uuid);
			curso.setThumbnail(anexo.getBytes());		
			return cursosRep.save(curso);	
		} catch (IOException e) {
			throw new  NullPointerException(e.getMessage());
		}	
	}
	
	public List<Cursos> findFilter(CursosFilter filter) {		
		return cursosRep.findAll();
	}
	
	public List<Cursos> findAll() {
		List<Cursos> cursos = cursosRep.findAll(CursoSpec.daSituacao(Situacao.ATIVO));		
		return cursos;		
	}	

	public Cursos findEvent(UUID uuid) {
		return cursosRep.findByUuid(uuid);
	}
	
	public void disable(UUID uuid) {
		Cursos curso = cursosRep.findByUuid(uuid);
		curso.setDisabledAt(new Date());
		cursosRep.save(curso);
	}
	
	public void enable(UUID uuid) {
		Cursos curso = cursosRep.findByUuid(uuid);
		curso.setDisabledAt(null);
		cursosRep.save(curso);
	}

}
