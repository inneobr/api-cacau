package org.inneo.cacau.services;

import org.inneo.cacau.model.Aulas;
import org.inneo.cacau.model.Cursos;

import lombok.RequiredArgsConstructor;
import org.inneo.cacau.repository.AulasRep;
import org.inneo.cacau.repository.CursosRep;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AulasService {
	private final AulasRep aulasRep;
	private final CursosRep cursoRep;

	public Aulas save(Aulas request) {		
		Aulas aula = request.getUuid() != null ? aulasRep.getReferenceById(request.getUuid()) : new Aulas();
		Cursos curso = cursoRep.findByUuid(request.getCurso().getUuid());
		if(curso == null) {
			throw new NullPointerException("Curso não encontrado");
		}
		request.setCreatedAt(aula.getCreatedAt());
		BeanUtils.copyProperties(request, aula);
		aula.setCurso(curso);
		return aulasRep.save(aula);		
	}
}
