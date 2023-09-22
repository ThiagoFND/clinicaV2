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

import com.example.demo.dto.EnderecoDTO;
import com.example.demo.service.EnderecoService;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

	@Autowired
	private EnderecoService enderecoService;

	// Endpoint para adicionar um novo contato na agenda
	@PostMapping(value = "/create",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public EnderecoDTO create(@RequestBody EnderecoDTO endereco) {
		return enderecoService.create(endereco);
	}
	
	// Endpoint para obter todos os contatos da agenda
	@GetMapping(value = "/list",
		produces = MediaType.APPLICATION_JSON_VALUE)
	public List<EnderecoDTO> findAll() {
		return enderecoService.findAll();
	}
	
	// Endpoint para atualizar os dados da agenda
	@PutMapping(value = "/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
	public EnderecoDTO update(@PathVariable Long id, @RequestBody EnderecoDTO endereco) {
		// Verifique se o ID é válido (não nulo)
		if (id == null) {
			throw new IllegalArgumentException("O ID não pode ser nulo.");
		}
		// Configure o ID no objeto 'exames'
		endereco.setId(id);

		// Chame o serviço 'examesService' para atualizar o exame
		EnderecoDTO updatedExame = enderecoService.update(endereco);
		return updatedExame;
	}
	
	// Endpoint para excluir um contato pelo id
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
		enderecoService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
