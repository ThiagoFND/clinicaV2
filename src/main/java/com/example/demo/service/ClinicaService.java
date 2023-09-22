package com.example.demo.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ClinicaDTO;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.mapper.DozerMapper;
import com.example.demo.model.Clinica;
import com.example.demo.repository.ClinicaRepository;

@Service
public class ClinicaService {

	private Logger logger = Logger.getLogger(ClinicaService.class.getName());

	@Autowired
	private ClinicaRepository clinicaRepository;

	public List<ClinicaDTO> findAll() {

		logger.info("Finding all people!");

		return DozerMapper.parseListObjects(clinicaRepository.findAll(), ClinicaDTO.class);
	}

	public ClinicaDTO findById(Long id) {

		logger.info("Finding one person!");

		var entity = clinicaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		return DozerMapper.parseObject(entity, ClinicaDTO.class);
	}

	public ClinicaDTO create(ClinicaDTO clinica) {

		logger.info("Creating one person!");
		var entity = DozerMapper.parseObject(clinica, Clinica.class);
		var vo = DozerMapper.parseObject(clinicaRepository.save(entity), ClinicaDTO.class);
		return vo;
	}

	public ClinicaDTO update(ClinicaDTO clinica) {

		logger.info("Updating one person!");

		var entity = clinicaRepository.findById(clinica.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

		entity.setBairro(clinica.getBairro());
		entity.setCep(clinica.getCep());
		entity.setCidade(clinica.getCidade());
		entity.setId(clinica.getId());
		entity.setNumeroClinica(clinica.getNumeroClinica());
		entity.setNumeroRua(clinica.getNumeroRua());
		entity.setRua(clinica.getRua());

		var vo = DozerMapper.parseObject(clinicaRepository.save(entity), ClinicaDTO.class);
		return vo;
	}

	public void delete(Long id) {

		logger.info("Deleting one person!");

		var entity = clinicaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		clinicaRepository.delete(entity);
	}
}
