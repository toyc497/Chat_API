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
	
	@Column(name="conteudo")
	private String conteudo;
	
	@ManyToOne
	@JoinColumn(name="edital_id")
	private EditalEntity edital;

	public Long getId() {
		return id;
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

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public void setEdital(EditalEntity edital) {
		this.edital = edital;
	}

	@Override
	public int hashCode() {
		return Objects.hash(conteudo, edital, id);
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
		return Objects.equals(conteudo, other.conteudo) && Objects.equals(edital, other.edital)
				&& Objects.equals(id, other.id);
	}
	
}
