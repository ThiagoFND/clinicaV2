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
@Table(name = "exames")
public class Exames {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "has", length = 50, nullable = true)
	private String has;
	@Column(name = "asmaBronquica", length = 50, nullable = true)
	private String asmaBronquica;
	@Column(name = "medicamentoUso", length = 50, nullable = true)
	private String medicamentoUso;
	@Column(name = "diabetesMellitus", length = 50, nullable = true)
	private String diabetesMellitus;
	@Column(name = "dpoc", length = 50, nullable = true)
	private String dpoc;
	@Column(name = "idade", length = 50, nullable = true)
	private String idade;
	@Column(name = "intercorrenciaAnestesica", length = 50, nullable = true)
	private String intercorrenciaAnestesica;
	@Column(name = "exameHermatologico", length = 50, nullable = true)
	private String exameHermatologico;
	@Column(name = "eletrocardiograma", length = 50, nullable = true)
	private String eletrocardiograma;
	@Column(name = "indicedeGoldman", length = 50, nullable = true)
	private String indicedeGoldman;
	@Column(name = "tabelaAsa", length = 50, nullable = true)
	private String tabelaAsa;
	@Column(name = "TabelaNyha", length = 50, nullable = true)
	private String TabelaNyha;
	@Column(name = "cirurgiaRisco", length = 50, nullable = true)
	private String cirurgiaRisco;
	@Column(name = "pacienteApto", length = 50, nullable = true)
	private String pacienteApto;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Pessoa pessoa;

	public Exames() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHas() {
		return has;
	}

	public void setHas(String has) {
		this.has = has;
	}

	public String getAsmaBronquica() {
		return asmaBronquica;
	}

	public void setAsmaBronquica(String asmaBronquica) {
		this.asmaBronquica = asmaBronquica;
	}

	public String getMedicamentoUso() {
		return medicamentoUso;
	}

	public void setMedicamentoUso(String medicamentoUso) {
		this.medicamentoUso = medicamentoUso;
	}

	public String getDiabetesMellitus() {
		return diabetesMellitus;
	}

	public void setDiabetesMellitus(String diabetesMellitus) {
		this.diabetesMellitus = diabetesMellitus;
	}

	public String getDpoc() {
		return dpoc;
	}

	public void setDpoc(String dpoc) {
		this.dpoc = dpoc;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public String getIntercorrenciaAnestesica() {
		return intercorrenciaAnestesica;
	}

	public void setIntercorrenciaAnestesica(String intercorrenciaAnestesica) {
		this.intercorrenciaAnestesica = intercorrenciaAnestesica;
	}

	public String getExameHermatologico() {
		return exameHermatologico;
	}

	public void setExameHermatologico(String exameHermatologico) {
		this.exameHermatologico = exameHermatologico;
	}

	public String getEletrocardiograma() {
		return eletrocardiograma;
	}

	public void setEletrocardiograma(String eletrocardiograma) {
		this.eletrocardiograma = eletrocardiograma;
	}

	public String getIndicedeGoldman() {
		return indicedeGoldman;
	}

	public void setIndicedeGoldman(String indicedeGoldman) {
		this.indicedeGoldman = indicedeGoldman;
	}

	public String getTabelaAsa() {
		return tabelaAsa;
	}

	public void setTabelaAsa(String tabelaAsa) {
		this.tabelaAsa = tabelaAsa;
	}

	public String getTabelaNyha() {
		return TabelaNyha;
	}

	public void setTabelaNyha(String tabelaNyha) {
		TabelaNyha = tabelaNyha;
	}

	public String getCirurgiaRisco() {
		return cirurgiaRisco;
	}

	public void setCirurgiaRisco(String cirurgiaRisco) {
		this.cirurgiaRisco = cirurgiaRisco;
	}

	public String getPacienteApto() {
		return pacienteApto;
	}

	public void setPacienteApto(String pacienteApto) {
		this.pacienteApto = pacienteApto;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public int hashCode() {
		return Objects.hash(TabelaNyha, asmaBronquica, cirurgiaRisco, diabetesMellitus, dpoc, eletrocardiograma,
				exameHermatologico, has, id, idade, indicedeGoldman, intercorrenciaAnestesica, medicamentoUso,
				pacienteApto, pessoa, tabelaAsa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Exames other = (Exames) obj;
		return Objects.equals(TabelaNyha, other.TabelaNyha) && Objects.equals(asmaBronquica, other.asmaBronquica)
				&& Objects.equals(cirurgiaRisco, other.cirurgiaRisco)
				&& Objects.equals(diabetesMellitus, other.diabetesMellitus) && Objects.equals(dpoc, other.dpoc)
				&& Objects.equals(eletrocardiograma, other.eletrocardiograma)
				&& Objects.equals(exameHermatologico, other.exameHermatologico) && Objects.equals(has, other.has)
				&& Objects.equals(id, other.id) && Objects.equals(idade, other.idade)
				&& Objects.equals(indicedeGoldman, other.indicedeGoldman)
				&& Objects.equals(intercorrenciaAnestesica, other.intercorrenciaAnestesica)
				&& Objects.equals(medicamentoUso, other.medicamentoUso)
				&& Objects.equals(pacienteApto, other.pacienteApto) && Objects.equals(pessoa, other.pessoa)
				&& Objects.equals(tabelaAsa, other.tabelaAsa);
	}

}
