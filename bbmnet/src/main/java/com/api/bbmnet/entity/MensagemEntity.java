package com.api.bbmnet.entity;

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
@Table(name="mensagem")
public class MensagemEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="origem")
	private String origem;
	
	@Column(name="data_hora")
	private String dataHora;
	
	@Column(name="conteudo")
	private String conteudo;
	
	@ManyToOne
	@JoinColumn(name="edital_id")
	private EditalEntity edital;

	public Long getId() {
		return id;
	}

	public String getOrigem() {
		return origem;
	}

	public String getDataHora() {
		return dataHora;
	}

	public String getConteudo() {
		return conteudo;
	}

	public EditalEntity getEdital() {
		return edital;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public void setDataHora(String dataHora) {
		this.dataHora = dataHora;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public void setEdital(EditalEntity edital) {
		this.edital = edital;
	}

	@Override
	public int hashCode() {
		return Objects.hash(conteudo, dataHora, edital, id, origem);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MensagemEntity other = (MensagemEntity) obj;
		return Objects.equals(conteudo, other.conteudo) && Objects.equals(dataHora, other.dataHora)
				&& Objects.equals(edital, other.edital) && Objects.equals(id, other.id)
				&& Objects.equals(origem, other.origem);
	}
	
}
