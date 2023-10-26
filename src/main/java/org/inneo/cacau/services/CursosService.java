package org.inneo.cacau.services;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.inneo.cacau.model.Cursos;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.inneo.cacau.repository.AulasRep;
import org.inneo.cacau.repository.CursosRep;

import org.inneo.cacau.records.CursosResponse;
import org.springframework.stereotype.Service;
import org.inneo.cacau.utilitarios.enums.Situacao;
import org.inneo.cacau.utilitarios.specs.CursoSpec;
import org.inneo.cacau.utilitarios.filters.CursosFilter;

@Service
@RequiredArgsConstructor
public class CursosService {	
	private final CursosRep cursosRep;
	private final AulasRep aulasRep;
	
	public Cursos save(Cursos request) {		
		Cursos curso = request.getUuid() != null ? cursosRep.findByUuid(request.getUuid()) : new Cursos();
		request.setCreatedAt(curso.getCreatedAt());
		BeanUtils.copyProperties(request, curso);
		return cursosRep.save(curso);		
	}	
	
	public List<Cursos> findFilter(CursosFilter filter) {		
		return cursosRep.findAll();
	}
	
	public List<CursosResponse> findAll() {
		List<Cursos> cursos = cursosRep.findAll(CursoSpec.daSituacao(Situacao.ATIVO));
		for(Cursos curso: cursos) {
			curso.getAulas().addAll(aulasRep.findByCurso(curso));
		}
		return cursos.stream().map(CursosResponse::new).toList();	
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
