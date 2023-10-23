package org.inneo.cacau.controller;

import java.util.List;
import java.util.UUID;

import org.inneo.cacau.model.Videos;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.inneo.cacau.services.VideosService;
import org.springframework.http.ResponseEntity;
import io.swagger.v3.oas.annotations.Operation;

import org.inneo.cacau.utilitarios.filters.VideosFilter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import org.springframework.web.bind.annotation.CrossOrigin;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/v1/videos")
@Tag(name = "Videos", description = "Retorna as funções de videos.")
public class VideosController {
	private final VideosService videosService;
	
	@Operation(summary = "Novo", method = "POST")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Cadastrado com sucesso!" ),
			@ApiResponse(responseCode = "400", description = "Requisição falhou." ),
			@ApiResponse(responseCode = "401", description = "Permissão negada!" )
	})
	@PostMapping
	public ResponseEntity<Videos> publicar(@RequestBody Videos videos) {
	   return ResponseEntity.ok(videosService.save(videos));
	}
	
	@Operation(summary = "Listar", method = "GET")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Carregada com sucesso!" ),
			@ApiResponse(responseCode = "400", description = "Requisição falhou." ),
			@ApiResponse(responseCode = "401", description = "Permissão negada!" )
	})
	@GetMapping
	public ResponseEntity<List<Videos>> findAll() {
	   return ResponseEntity.ok(videosService.findAll());
	}
	
	@Operation(summary = "Filtrar", method = "GET")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Carregada com sucesso!" ),
			@ApiResponse(responseCode = "400", description = "Requisição falhou." ),
			@ApiResponse(responseCode = "401", description = "Permissão negada!" )
	})
	@GetMapping("/filtrar")
	public ResponseEntity<List<Videos>> findFilter(VideosFilter filter) {
	   return ResponseEntity.ok(videosService.findFilter(filter));
	}
	
	@Operation(summary = "Unico", method = "GET")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Carregada com sucesso!" ),
			@ApiResponse(responseCode = "400", description = "Requisição falhou." ),
			@ApiResponse(responseCode = "401", description = "Permissão negada!" )
	})
	@GetMapping("/evento")
	public ResponseEntity<Videos> findEvent(@RequestParam(name="uuid") UUID uuid) {
	   return ResponseEntity.ok(videosService.findEvent(uuid));
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
			videosService.disable(uuid);
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
			videosService.enable(uuid);
			return new ResponseEntity<>("Evento publicado com sucesso.", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("Não foi possivel publicar o evento.", HttpStatus.CREATED);
		}	
	}
}
