package com.example.demo.dto;

import java.sql.Date;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pessoa")
public class PessoaDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String idade;
	private String sexo;
	private Date data;

	@ManyToOne
	@JoinColumn(nullable = false)
	private MedicoDTO atendimento;

	public PessoaDTO() {
		super();
	}

	public PessoaDTO(Long id, String idade, String sexo, Date data, MedicoDTO atendimento) {
		super();
		this.id = id;
		this.idade = idade;
		this.sexo = sexo;
		this.data = data;
		this.atendimento = atendimento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public MedicoDTO getAtendimento() {
		return atendimento;
	}

	public void setAtendimento(MedicoDTO atendimento) {
		this.atendimento = atendimento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(atendimento, data, id, idade, sexo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PessoaDTO other = (PessoaDTO) obj;
		return Objects.equals(atendimento, other.atendimento) && Objects.equals(data, other.data)
				&& Objects.equals(id, other.id) && Objects.equals(idade, other.idade)
				&& Objects.equals(sexo, other.sexo);
	}

}
