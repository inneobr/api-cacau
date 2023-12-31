package org.inneo.cacau.services;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.inneo.cacau.model.Eventos;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.inneo.cacau.repository.EventosRep;
import org.springframework.stereotype.Service;

import org.inneo.cacau.utilitarios.enums.Situacao;
import org.inneo.cacau.utilitarios.specs.SpecEventos;
import org.inneo.cacau.utilitarios.filters.EventosFilter;


@Service
@RequiredArgsConstructor
public class EventosService {	
	private final EventosRep eventosRep;
	
	public Eventos save(Eventos request) {		
		Eventos eventos = request.getUuid() != null ? eventosRep.findByUuid(request.getUuid()) : new Eventos();
		request.setCreatedAt(eventos.getCreatedAt());
		BeanUtils.copyProperties(request, eventos);
		return eventosRep.save(eventos);		
	}	
	
	public List<Eventos> findFilter(EventosFilter filter) {
		return eventosRep.findAll();
	}
	
	public List<Eventos> findAll() {
		List<Eventos> eventos = eventosRep.findAll(SpecEventos.daSituacao(Situacao.ATIVO));
		return eventos;		
	}
	
	public Eventos findEvent(UUID uuid) {
		return eventosRep.findByUuid(uuid);
	}
	
	public void disable(UUID uuid) {
		Eventos evento = eventosRep.findByUuid(uuid);
		evento.setDisabledAt(new Date());
		eventosRep.save(evento);
	}
	
	public void enable(UUID uuid) {
		Eventos evento = eventosRep.findByUuid(uuid);
		evento.setDisabledAt(null);
		eventosRep.save(evento);
	}
}
