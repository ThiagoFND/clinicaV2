package com.example.demo.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ExameFisicoDTO;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.mapper.DozerMapper;
import com.example.demo.model.ExameFisico;
import com.example.demo.repository.ExameFisicoRepository;

@Service
public class ExameFisicoService {

	private Logger logger = Logger.getLogger(ExameFisicoService.class.getName());

	@Autowired
	private ExameFisicoRepository exameFisicoRepository;

	public List<ExameFisicoDTO> findAll() {

		logger.info("Finding all people!");

		return DozerMapper.parseListObjects(exameFisicoRepository.findAll(), ExameFisicoDTO.class);
	}

	public ExameFisicoDTO findById(Long id) {

		logger.info("Finding one person!");

		var entity = exameFisicoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		return DozerMapper.parseObject(entity, ExameFisicoDTO.class);
	}

	public ExameFisicoDTO create(ExameFisicoDTO examefisico) {

		logger.info("Creating one person!");
		var entity = DozerMapper.parseObject(examefisico, ExameFisico.class);
		var vo = DozerMapper.parseObject(exameFisicoRepository.save(entity), ExameFisicoDTO.class);
		return vo;
	}

	public ExameFisicoDTO update(ExameFisicoDTO examefisico) {

		logger.info("Updating one person!");

		var entity = exameFisicoRepository.findById(examefisico.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

		entity.setAcv(examefisico.getAcv());
		entity.setAr(examefisico.getAr());
		entity.setEstadoGeral(examefisico.getEstadoGeral());
		entity.setId(examefisico.getId());
		entity.setNumero(examefisico.getNumero());
		entity.setTa(examefisico.getTa());
		
		var vo = DozerMapper.parseObject(exameFisicoRepository.save(entity), ExameFisicoDTO.class);
		return vo;
	}

	public void delete(Long id) {

		logger.info("Deleting one person!");

		var entity = exameFisicoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		exameFisicoRepository.delete(entity);
	}
}
