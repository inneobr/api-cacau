package org.inneo.cacau.services;

import org.mockito.Mock;
import org.junit.jupiter.api.Test;
import org.inneo.cacau.model.Aulas;
import org.inneo.cacau.model.Cursos;

import static org.mockito.Mockito.when;
import org.inneo.cacau.repository.CursosRep;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest
public class CursoServiceTest {
	@Autowired
	private CursosService cursoService;
	
	@Mock
	private CursosRep cursosRep;

	@Mock
	private Cursos curso;
	
	@Test
	public void saveTest() {
		getVideo();
		when(cursosRep.save(curso)).thenReturn(curso);
		var create = cursoService.save(curso);
		assertNotNull(create.getUuid());
		
	} 
	
	@Test
	public void findAllTest() {
		var create = cursoService.findAll();
		assertNotNull(create);		
	} 
	
	public Aulas getVideo() {
		Aulas videos = new Aulas();
		videos.setTitulo("Blusinha");
		return videos;
	}
}
