package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.clinicaDockerDTO;


@RestController
@RequestMapping("/docker")
public class DockerController {
	
	Logger logger = LoggerFactory.getLogger(DockerController.class);
	
	@RequestMapping("/hello-docker")
	public clinicaDockerDTO greeting() {
		
		logger.info("Endpoint /hello-docker is called!!!");
		
		//var hostName = System.getenv("COMPUTERNAME");
		var hostName = System.getenv("HOSTNAME");
		
		return new clinicaDockerDTO(
					"Hello Docker",
					hostName
				);
	}
}