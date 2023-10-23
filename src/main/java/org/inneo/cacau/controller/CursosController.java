package org.inneo.cacau.controller;

import java.util.List;
import java.util.UUID;

import org.inneo.cacau.model.Cursos;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.inneo.cacau.services.CursosService;
import org.springframework.http.ResponseEntity;
import io.swagger.v3.oas.annotations.Operation;

import org.inneo.cacau.utilitarios.filters.CursosFilter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import org.springframework.web.bind.annotation.CrossOrigin;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/v1/cursos")
@Tag(name = "Cursos", description = "Retorna as funções de cursos.")
public class CursosController {
	private final CursosService cursoService;
	
	@Operation(summary = "Novo", method = "POST")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Cadastrado com sucesso!" ),
			@ApiResponse(responseCode = "400", description = "Requisição falhou." ),
			@ApiResponse(responseCode = "401", description = "Permissão negada!" )
	})
	@PostMapping
	public ResponseEntity<Cursos> save(@RequestBody Cursos curso) {
	   return ResponseEntity.ok(cursoService.save(curso));
	}
	
	@Operation(summary = "Anexos", method = "POST")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Cadastrado com sucesso!" ),
			@ApiResponse(responseCode = "400", description = "Requisição falhou." ),
			@ApiResponse(responseCode = "401", description = "Permissão negada!" )
	})
	@PostMapping("/thumbnail")
	public ResponseEntity<Cursos> thumbnail(
			@RequestParam("uuid") UUID uuid,
			@RequestParam("anexo") MultipartFile anexo){
		return ResponseEntity.ok(cursoService.thumbnail(uuid, anexo));
	}
	
	@Operation(summary = "Listar", method = "GET")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Carregada com sucesso!" ),
			@ApiResponse(responseCode = "400", description = "Requisição falhou." ),
			@ApiResponse(responseCode = "401", description = "Permissão negada!" )
	})
	@GetMapping
	public ResponseEntity<List<Cursos>> findAll() {
	   return ResponseEntity.ok(cursoService.findAll());
	}
	
	@Operation(summary = "Filtrar", method = "GET")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Carregada com sucesso!" ),
			@ApiResponse(responseCode = "400", description = "Requisição falhou." ),
			@ApiResponse(responseCode = "401", description = "Permissão negada!" )
	})
	@GetMapping("/filtrar")
	public ResponseEntity<List<Cursos>> findFilter(CursosFilter filter) {
	   return ResponseEntity.ok(cursoService.findFilter(filter));
	}
	
	@Operation(summary = "Unico", method = "GET")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Carregada com sucesso!" ),
			@ApiResponse(responseCode = "400", description = "Requisição falhou." ),
			@ApiResponse(responseCode = "401", description = "Permissão negada!" )
	})
	@GetMapping("/burcar")
	public ResponseEntity<Cursos> findEvent(@RequestParam(name="uuid") UUID uuid) {
	   return ResponseEntity.ok(cursoService.findEvent(uuid));
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
			cursoService.disable(uuid);
			return new ResponseEntity<>("Curso arquivado com sucesso.", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("Não foi possivel arquivar o curso.", HttpStatus.BAD_REQUEST);
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
			cursoService.enable(uuid);
			return new ResponseEntity<>("Curso publicado com sucesso.", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("Não foi possivel publicar o curso.", HttpStatus.BAD_REQUEST);
		}	
	}
}
