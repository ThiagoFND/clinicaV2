package com.example.demo.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.EnderecoDTO;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.mapper.DozerMapper;
import com.example.demo.model.Endereco;
import com.example.demo.repository.EnderecoRepository;

@Service
public class EnderecoService {

	private Logger logger = Logger.getLogger(EnderecoService.class.getName());

	@Autowired
	private EnderecoRepository EnderecoRepository;

	public List<EnderecoDTO> findAll() {

		logger.info("Finding all people!");

		return DozerMapper.parseListObjects(EnderecoRepository.findAll(), EnderecoDTO.class);
	}

	public EnderecoDTO findById(Long id) {

		logger.info("Finding one person!");

		var entity = EnderecoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		return DozerMapper.parseObject(entity, EnderecoDTO.class);
	}

	public EnderecoDTO create(EnderecoDTO endereco) {

		logger.info("Creating one person!");
		var entity = DozerMapper.parseObject(endereco, Endereco.class);
		var vo = DozerMapper.parseObject(EnderecoRepository.save(entity), EnderecoDTO.class);
		return vo;
	}

	public EnderecoDTO update(EnderecoDTO endereco) {

		logger.info("Updating one person!");

		var entity = EnderecoRepository.findById(endereco.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

//		entity.setBairro(clinica.getBairro());

		var vo = DozerMapper.parseObject(EnderecoRepository.save(entity), EnderecoDTO.class);
		return vo;
	}

	public void delete(Long id) {

		logger.info("Deleting one person!");

		var entity = EnderecoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		EnderecoRepository.delete(entity);
	}
}
