package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.MedicoDTO;
import com.example.demo.service.MedicoService;

@RestController
@RequestMapping("/medico")
public class MedicoController {

	@Autowired
	private MedicoService medicoService;

	// Endpoint para adicionar um novo contato na agenda
	@PostMapping(value = "/create",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public MedicoDTO create(@RequestBody MedicoDTO medico) {
		return medicoService.create(medico);
	}
	
	// Endpoint para obter todos os contatos da agenda
	@GetMapping(value = "/list",
		produces = MediaType.APPLICATION_JSON_VALUE)
	public List<MedicoDTO> findAll() {
		return medicoService.findAll();
	}
	
	// Endpoint para atualizar os dados da agenda
	@PutMapping(value = "/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
	public MedicoDTO update(@PathVariable Long id, @RequestBody MedicoDTO medico) {
		// Verifique se o ID é válido (não nulo)
		if (id == null) {
			throw new IllegalArgumentException("O ID não pode ser nulo.");
		}
		// Configure o ID no objeto 'exames'
		medico.setId(id);

		// Chame o serviço 'examesService' para atualizar o exame
		MedicoDTO updatedExame = medicoService.update(medico);
		return updatedExame;
	}
	
	// Endpoint para excluir um contato pelo id
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
		medicoService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
