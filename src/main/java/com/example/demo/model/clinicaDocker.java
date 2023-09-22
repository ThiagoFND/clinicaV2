package com.example.demo.model;

public class clinicaDocker {
	
	private final String content;
	private final String environment;
	
	public clinicaDocker(String content, String environment) {
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