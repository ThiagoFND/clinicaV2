package com.example.demo.dto;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "medico")
public class MedicoDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	private String especializacao;

	@ManyToOne
	@JoinColumn(nullable = false)
	private ClinicaDTO clinica;

	public MedicoDTO() {
	}

	public MedicoDTO(Long id, String nome, String especializacao, ClinicaDTO clinica) {
		super();
		this.id = id;
		this.nome = nome;
		this.especializacao = especializacao;
		this.clinica = clinica;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEspecializacao() {
		return especializacao;
	}

	public void setEspecializacao(String especializacao) {
		this.especializacao = especializacao;
	}

	public ClinicaDTO getClinica() {
		return clinica;
	}

	public void setClinica(ClinicaDTO clinica) {
		this.clinica = clinica;
	}

	@Override
	public int hashCode() {
		return Objects.hash(clinica, especializacao, id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MedicoDTO other = (MedicoDTO) obj;
		return Objects.equals(clinica, other.clinica) && Objects.equals(especializacao, other.especializacao)
				&& Objects.equals(id, other.id) && Objects.equals(nome, other.nome);
	}

}
