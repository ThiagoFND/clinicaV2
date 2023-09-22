package com.example.demo.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.PessoaDTO;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.mapper.DozerMapper;
import com.example.demo.model.Pessoa;
import com.example.demo.repository.PessoaRepository;

@Service
public class PessoaService {

	private Logger logger = Logger.getLogger(MedicoService.class.getName());
	
	@Autowired
	private PessoaRepository pessoaRepository;

	public List<PessoaDTO> findAll() {

		logger.info("Finding all people!");

		return DozerMapper.parseListObjects(pessoaRepository.findAll(), PessoaDTO.class);
	}

	public PessoaDTO findById(Long id) {

		logger.info("Finding one person!");

		var entity = pessoaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		return DozerMapper.parseObject(entity, PessoaDTO.class);
	}

	public PessoaDTO create(PessoaDTO pessoa) {

		logger.info("Creating one person!");
		var entity = DozerMapper.parseObject(pessoa, Pessoa.class);
		var vo = DozerMapper.parseObject(pessoaRepository.save(entity), PessoaDTO.class);
		return vo;
	}

	public PessoaDTO update(PessoaDTO pessoa) {

		logger.info("Updating one person!");

		var entity = pessoaRepository.findById(pessoa.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

		entity.setData(pessoa.getData());
		entity.setId(pessoa.getId());
		entity.setIdade(pessoa.getIdade());
		entity.setSexo(pessoa.getSexo());

		var vo = DozerMapper.parseObject(pessoaRepository.save(entity), PessoaDTO.class);
		return vo;
	}

	public void delete(Long id) {

		logger.info("Deleting one person!");

		var entity = pessoaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		pessoaRepository.delete(entity);
	}

}
