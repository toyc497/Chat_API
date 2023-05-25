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
@Table(name="credenciais")
public class CredenciaisEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="usuario",unique=true)
	private String usuario;
	
	@Column(name="senha")
	private String senha;
	
	@ManyToOne
	@JoinColumn(name="sistema_id")
	private SistemaEntity sistema;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public SistemaEntity getSistema() {
		return sistema;
	}

	public void setSistema(SistemaEntity sistema) {
		this.sistema = sistema;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, senha, sistema, usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CredenciaisEntity other = (CredenciaisEntity) obj;
		return Objects.equals(id, other.id) && Objects.equals(senha, other.senha)
				&& Objects.equals(sistema, other.sistema) && Objects.equals(usuario, other.usuario);
	}
	
}
