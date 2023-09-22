package com.example.demo.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "clinica")
public class Clinica {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String numeroClinica;
	@Column(name = "cep", length = 15, nullable = true)
	private String cep;
	@Column(name = "cidade", length = 30, nullable = true)
	private String cidade;
	@Column(name = "bairro", length = 50, nullable = true)
	private String bairro;
	@Column(name = "rua", length = 40, nullable = true)
	private String rua;
	@Column(name = "numeroRua", length = 15, nullable = true)
	private String numeroRua;

	public Clinica() {
	}

	public Clinica(Long id, String numeroClinica, String cep, String cidade, String bairro, String rua,
			String numeroRua) {
		this.id = id;
		this.numeroClinica = numeroClinica;
		this.cep = cep;
		this.cidade = cidade;
		this.bairro = bairro;
		this.rua = rua;
		this.numeroRua = numeroRua;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumeroClinica() {
		return numeroClinica;
	}

	public void setNumeroClinica(String numeroClinica) {
		this.numeroClinica = numeroClinica;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumeroRua() {
		return numeroRua;
	}

	public void setNumeroRua(String numeroRua) {
		this.numeroRua = numeroRua;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bairro, cep, cidade, id, numeroClinica, numeroRua, rua);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Clinica other = (Clinica) obj;
		return Objects.equals(bairro, other.bairro) && Objects.equals(cep, other.cep)
				&& Objects.equals(cidade, other.cidade) && Objects.equals(id, other.id)
				&& Objects.equals(numeroClinica, other.numeroClinica) && Objects.equals(numeroRua, other.numeroRua)
				&& Objects.equals(rua, other.rua);
	}

}
