package com.api.bbmnet.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="sistema")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class SistemaEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nome",unique=true)
	private String nome;
	
	@OneToMany(mappedBy = "sistema",fetch = FetchType.LAZY)
	@JsonIgnore
	private List<CredenciaisEntity> credenciais = new ArrayList<>();

	@OneToMany(mappedBy = "sistema",fetch = FetchType.LAZY)
	@JsonIgnore
	private List<EditalEntity> editais = new ArrayList<>();
	
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

	public List<CredenciaisEntity> getCredenciais() {
		return credenciais;
	}

	public void setCredenciais(List<CredenciaisEntity> credenciais) {
		this.credenciais = credenciais;
	}

	public List<EditalEntity> getEditais() {
		return editais;
	}

	public void setEditais(List<EditalEntity> editais) {
		this.editais = editais;
	}

	@Override
	public int hashCode() {
		return Objects.hash(credenciais, editais, id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SistemaEntity other = (SistemaEntity) obj;
		return Objects.equals(credenciais, other.credenciais) && Objects.equals(editais, other.editais)
				&& Objects.equals(id, other.id) && Objects.equals(nome, other.nome);
	}
	
}
