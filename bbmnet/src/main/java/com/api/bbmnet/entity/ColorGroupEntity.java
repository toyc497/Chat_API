package com.api.bbmnet.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="colorgroup")
public class ColorGroupEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nome")
	@NotNull
	private String nome;
	
	@Column(name="hexadecimal_code")
	@NotNull
	private String hexadecimalCode;
	
	@OneToMany(mappedBy = "colorGroup", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<PalavraChaveEntity> palavrasChave = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getHexadecimalCode() {
		return hexadecimalCode;
	}

	public List<PalavraChaveEntity> getPalavrasChave() {
		return palavrasChave;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setHexadecimalCode(String hexadecimalCode) {
		this.hexadecimalCode = hexadecimalCode;
	}

	public void setPalavrasChave(List<PalavraChaveEntity> palavrasChave) {
		this.palavrasChave = palavrasChave;
	}

	@Override
	public int hashCode() {
		return Objects.hash(hexadecimalCode, id, nome, palavrasChave);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ColorGroupEntity other = (ColorGroupEntity) obj;
		return Objects.equals(hexadecimalCode, other.hexadecimalCode) && Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome) && Objects.equals(palavrasChave, other.palavrasChave);
	}
	
}
