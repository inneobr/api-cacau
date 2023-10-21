package org.inneo.cacau.services;

import org.mockito.Mock;
import org.junit.jupiter.api.Test;
import org.inneo.cacau.model.Eventos;
import static org.mockito.Mockito.when;
import org.inneo.cacau.repository.EventosRep;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.springframework.beans.factory.annotation.Autowired;


@SpringBootTest
public class EventosServiceTest {
	
	@Autowired
	private EventosService eventosService;
	
	@Mock
	private EventosRep eventosRep;

	@Mock
	private Eventos evento;
	
	@Test
	public void saveTest() {
		getEvento();
		when(eventosRep.save(evento)).thenReturn(evento);
		var create = eventosService.save(evento);
		assertNotNull(create.getUuid());
		
	} 
	
	@Test
	public void findAllTest() {
		var create = eventosService.findAll();
		assertNotNull(create);		
	} 
	
	public Eventos getEvento() {
		Eventos evento = new Eventos();
		evento.setLocalizacao("Clube Maria Bonita");
		return evento;
	}
}
