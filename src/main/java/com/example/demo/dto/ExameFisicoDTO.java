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
@Table(name = "examefisico")
public class ExameFisicoDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String ar;
	private String acv;
	private String numero;
	private String ta;
	private String estadoGeral;

	@ManyToOne
	@JoinColumn(nullable = false)
	private ExamesDTO exames;

	public ExameFisicoDTO() {
	}

	public ExameFisicoDTO(Long id, String ar, String acv, String numero, String ta, String estadoGeral,
			ExamesDTO exames) {
		super();
		this.id = id;
		this.ar = ar;
		this.acv = acv;
		this.numero = numero;
		this.ta = ta;
		this.estadoGeral = estadoGeral;
		this.exames = exames;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAr() {
		return ar;
	}

	public void setAr(String ar) {
		this.ar = ar;
	}

	public String getAcv() {
		return acv;
	}

	public void setAcv(String acv) {
		this.acv = acv;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTa() {
		return ta;
	}

	public void setTa(String ta) {
		this.ta = ta;
	}

	public String getEstadoGeral() {
		return estadoGeral;
	}

	public void setEstadoGeral(String estadoGeral) {
		this.estadoGeral = estadoGeral;
	}

	public ExamesDTO getExames() {
		return exames;
	}

	public void setExames(ExamesDTO exames) {
		this.exames = exames;
	}

	@Override
	public int hashCode() {
		return Objects.hash(acv, ar, estadoGeral, exames, id, numero, ta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExameFisicoDTO other = (ExameFisicoDTO) obj;
		return Objects.equals(acv, other.acv) && Objects.equals(ar, other.ar)
				&& Objects.equals(estadoGeral, other.estadoGeral) && Objects.equals(exames, other.exames)
				&& Objects.equals(id, other.id) && Objects.equals(numero, other.numero) && Objects.equals(ta, other.ta);
	}

}
