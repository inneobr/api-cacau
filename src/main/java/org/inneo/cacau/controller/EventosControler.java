package org.inneo.cacau.controller;

import java.util.List;
import java.util.UUID;

import org.inneo.cacau.model.Eventos;
import org.inneo.cacau.services.EventosService;
import org.inneo.cacau.utilitarios.filters.EventosFilter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/v1/eventos")
@Tag(name = "Eventos", description = "Retorna as funções de eventos.")
public class EventosControler {
	private final EventosService eventosService;
	
	@Operation(summary = "Novo", method = "POST")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Cadastrado com sucesso!" ),
			@ApiResponse(responseCode = "400", description = "Requisição falhou." ),
			@ApiResponse(responseCode = "401", description = "Permissão negada!" )
	})
	@PostMapping
	public ResponseEntity<Eventos> publicar(@RequestBody Eventos evento) {
	   return ResponseEntity.ok(eventosService.save(evento));
	}
	
	@Operation(summary = "Listar", method = "GET")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Carregada com sucesso!" ),
			@ApiResponse(responseCode = "400", description = "Requisição falhou." ),
			@ApiResponse(responseCode = "401", description = "Permissão negada!" )
	})
	@GetMapping
	public ResponseEntity<List<Eventos>> findAll() {
	   return ResponseEntity.ok(eventosService.findAll());
	}
	
	@Operation(summary = "Filtrar", method = "GET")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Carregada com sucesso!" ),
			@ApiResponse(responseCode = "400", description = "Requisição falhou." ),
			@ApiResponse(responseCode = "401", description = "Permissão negada!" )
	})
	@GetMapping("/filtrar")
	public ResponseEntity<List<Eventos>> findFilter(EventosFilter filter) {
	   return ResponseEntity.ok(eventosService.findFilter(filter));
	}
	
	@Operation(summary = "Unico", method = "GET")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Carregada com sucesso!" ),
			@ApiResponse(responseCode = "400", description = "Requisição falhou." ),
			@ApiResponse(responseCode = "401", description = "Permissão negada!" )
	})
	@GetMapping("/evento")
	public ResponseEntity<Eventos> findEvent(@RequestParam(name="uuid") UUID uuid) {
	   return ResponseEntity.ok(eventosService.findEvent(uuid));
	}
	
	@Operation(summary = "Disable", method = "GET")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Carregada com sucesso!" ),
			@ApiResponse(responseCode = "400", description = "Requisição falhou." ),
			@ApiResponse(responseCode = "401", description = "Permissão negada!" )
	})
	@GetMapping("/disable")
	public ResponseEntity<?> disable(@RequestParam(name="uuid") UUID uuid) {
		try {
			eventosService.disable(uuid);
			return new ResponseEntity<>("Evento arquivado com sucesso.", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("Não foi possivel arquivar o evento.", HttpStatus.CREATED);
		}
	}
	
	@Operation(summary = "Enable", method = "GET")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Carregada com sucesso!" ),
			@ApiResponse(responseCode = "400", description = "Requisição falhou." ),
			@ApiResponse(responseCode = "401", description = "Permissão negada!" )
	})
	@GetMapping("/enable")
	public ResponseEntity<?> enable(@RequestParam(name="uuid") UUID uuid) {
		try {
			eventosService.enable(uuid);
			return new ResponseEntity<>("Evento publicado com sucesso.", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("Não foi possivel publicar o evento.", HttpStatus.CREATED);
		}	
	}

}
