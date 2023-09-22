package com.example.demo.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.MedicoDTO;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.mapper.DozerMapper;
import com.example.demo.model.Medico;
import com.example.demo.repository.MedicoRepository;

@Service
public class MedicoService {

	private Logger logger = Logger.getLogger(MedicoService.class.getName());
	
	@Autowired
	private MedicoRepository medicoRepository;
	
	public List<MedicoDTO> findAll() {

		logger.info("Finding all people!");

		return DozerMapper.parseListObjects(medicoRepository.findAll(), MedicoDTO.class);
	}

	public MedicoDTO findById(Long id) {

		logger.info("Finding one person!");

		var entity = medicoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		return DozerMapper.parseObject(entity, MedicoDTO.class);
	}

	public MedicoDTO create(MedicoDTO medico) {

		logger.info("Creating one person!");
		var entity = DozerMapper.parseObject(medico, Medico.class);
		var vo = DozerMapper.parseObject(medicoRepository.save(entity), MedicoDTO.class);
		return vo;
	}

	public MedicoDTO update(MedicoDTO medico) {

		logger.info("Updating one person!");

		var entity = medicoRepository.findById(medico.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

//		entity.setAcv(examefisico.getAcv());
		entity.setEspecializacao(medico.getEspecializacao());
		entity.setId(medico.getId());
		entity.setNome(medico.getNome());
		
		var vo = DozerMapper.parseObject(medicoRepository.save(entity), MedicoDTO.class);
		return vo;
	}

	public void delete(Long id) {

		logger.info("Deleting one person!");

		var entity = medicoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		medicoRepository.delete(entity);
	}
}
