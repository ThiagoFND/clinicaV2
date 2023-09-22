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
@Table(name = "exames")
public class ExamesDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String has;
	private String asmaBronquica;
	private String medicamentoUso;
	private String diabetesMellitus;
	private String dpoc;
	private String idade;
	private String intercorrenciaAnestesica;
	private String exameHermatologico;
	private String eletrocardiograma;
	private String indicedeGoldman;
	private String tabelaAsa;
	private String TabelaNyha;
	private String cirurgiaRisco;
	private String pacienteApto;

	@ManyToOne
	@JoinColumn(nullable = false)
	private PessoaDTO pessoa;

	public ExamesDTO() {
	}

	public ExamesDTO(Long id, String has, String asmaBronquica, String medicamentoUso, String diabetesMellitus,
			String dpoc, String idade, String intercorrenciaAnestesica, String exameHermatologico,
			String eletrocardiograma, String indicedeGoldman, String tabelaAsa, String tabelaNyha, String cirurgiaRisco,
			String pacienteApto, PessoaDTO pessoa) {
		super();
		this.id = id;
		this.has = has;
		this.asmaBronquica = asmaBronquica;
		this.medicamentoUso = medicamentoUso;
		this.diabetesMellitus = diabetesMellitus;
		this.dpoc = dpoc;
		this.idade = idade;
		this.intercorrenciaAnestesica = intercorrenciaAnestesica;
		this.exameHermatologico = exameHermatologico;
		this.eletrocardiograma = eletrocardiograma;
		this.indicedeGoldman = indicedeGoldman;
		this.tabelaAsa = tabelaAsa;
		TabelaNyha = tabelaNyha;
		this.cirurgiaRisco = cirurgiaRisco;
		this.pacienteApto = pacienteApto;
		this.pessoa = pessoa;
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

	public PessoaDTO getPessoa() {
		return pessoa;
	}

	public void setPessoa(PessoaDTO pessoa) {
		this.pessoa = pessoa;
	}

	public void setPacienteApto(String pacienteApto) {
		this.pacienteApto = pacienteApto;
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
		ExamesDTO other = (ExamesDTO) obj;
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
