package com.example.demo.dto;

public class clinicaDockerDTO {
	
	private final String content;
	private final String environment;
	
	public clinicaDockerDTO(String content, String environment) {
		this.content = content;
		this.environment = environment;
	}

	public String getContent() {
		return content;
	}

	public String getEnvironment() {
		return environment;
	}
}