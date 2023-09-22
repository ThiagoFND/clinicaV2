package com.example.demo.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "endereco")
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "uf", length = 15, nullable = true)
	private String uf;
	@Column(name = "cep", length = 15, nullable = true)
	private String cep;
	@Column(name = "cidade", length = 30, nullable = true)
	private String cidade;
	@Column(name = "bairro", length = 50, nullable = true)
	private String bairro;
	@Column(name = "rua", length = 40, nullable = true)
	private String rua;
	@Column(name = "numero", length = 15, nullable = true)
	private String numero;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Pessoa pessoa;

	public Endereco() {
	}

	public Endereco(Long id, String uf, String cep, String cidade, String bairro, String rua, String numero,
			Pessoa pessoa) {
		super();
		this.id = id;
		this.uf = uf;
		this.cep = cep;
		this.cidade = cidade;
		this.bairro = bairro;
		this.rua = rua;
		this.numero = numero;
		this.pessoa = pessoa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
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

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bairro, cep, cidade, id, numero, pessoa, rua, uf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		return Objects.equals(bairro, other.bairro) && Objects.equals(cep, other.cep)
				&& Objects.equals(cidade, other.cidade) && Objects.equals(id, other.id)
				&& Objects.equals(numero, other.numero) && Objects.equals(pessoa, other.pessoa)
				&& Objects.equals(rua, other.rua) && Objects.equals(uf, other.uf);
	}

}
