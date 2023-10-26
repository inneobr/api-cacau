package org.inneo.cacau.controller;

import org.inneo.cacau.model.Aulas;
import lombok.RequiredArgsConstructor;
import org.inneo.cacau.services.AulasService;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import io.swagger.v3.oas.annotations.Operation;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/v1/aulas")
@Tag(name = "Aulas", description = "Retorna as funções de aulas.")
public class AulaController {
	private final AulasService aulasService;
	
	@Operation(summary = "Novo", method = "POST")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Cadastrado com sucesso!" ),
			@ApiResponse(responseCode = "400", description = "Requisição falhou." ),
			@ApiResponse(responseCode = "401", description = "Permissão negada!" )
	})
	@PostMapping
	public ResponseEntity<Aulas> save(@RequestBody Aulas aula) {
	   return ResponseEntity.ok(aulasService.save(aula));
	}
}
