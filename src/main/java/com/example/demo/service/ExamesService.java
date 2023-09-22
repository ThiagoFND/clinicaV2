package com.example.demo.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ExamesDTO;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.mapper.DozerMapper;
import com.example.demo.model.Exames;
import com.example.demo.repository.ExamesRepository;

@Service
public class ExamesService {

	private Logger logger = Logger.getLogger(ExamesService.class.getName());
	
	@Autowired
	private ExamesRepository examesRepository;
	
	public List<ExamesDTO> findAll() {

		logger.info("Finding all people!");

		return DozerMapper.parseListObjects(examesRepository.findAll(), ExamesDTO.class);
	}

	public ExamesDTO findById(Long id) {

		logger.info("Finding one person!");

		var entity = examesRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		return DozerMapper.parseObject(entity, ExamesDTO.class);
	}

	public ExamesDTO create(ExamesDTO exames) {

		logger.info("Creating one person!");
		var entity = DozerMapper.parseObject(exames, Exames.class);
		var vo = DozerMapper.parseObject(examesRepository.save(entity), ExamesDTO.class);
		return vo;
	}

	public ExamesDTO update(ExamesDTO exames) {

		logger.info("Updating one person!");

		var entity = examesRepository.findById(exames.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

//		entity.setBairro(clinica.getBairro());
		entity.setAsmaBronquica(exames.getAsmaBronquica());
		entity.setCirurgiaRisco(exames.getCirurgiaRisco());
		entity.setDiabetesMellitus(exames.getDiabetesMellitus());
		entity.setDpoc(exames.getDpoc());
		entity.setEletrocardiograma(exames.getEletrocardiograma());
		entity.setExameHermatologico(exames.getExameHermatologico());
		entity.setHas(exames.getHas());
		entity.setId(exames.getId());
		entity.setIdade(exames.getIdade());
		entity.setIndicedeGoldman(exames.getIndicedeGoldman());
		entity.setIntercorrenciaAnestesica(exames.getIntercorrenciaAnestesica());
		entity.setMedicamentoUso(exames.getMedicamentoUso());
		entity.setPacienteApto(exames.getPacienteApto());
		entity.setTabelaAsa(exames.getTabelaAsa());
		entity.setTabelaNyha(exames.getTabelaNyha());

		var vo = DozerMapper.parseObject(examesRepository.save(entity), ExamesDTO.class);
		return vo;
	}

	public void delete(Long id) {

		logger.info("Deleting one person!");

		var entity = examesRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		examesRepository.delete(entity);
	}
}
