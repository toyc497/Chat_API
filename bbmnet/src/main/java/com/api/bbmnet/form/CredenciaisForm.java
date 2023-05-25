package com.api.bbmnet.form;

import jakarta.validation.constraints.NotNull;

public class CredenciaisForm {
	
	private Long id;
	
	private String usuario;
	
	private String senha;
	
	@NotNull
	private Long idSistema;
	
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

	public Long getIdSistema() {
		return idSistema;
	}

	public void setIdSistema(Long idSistema) {
		this.idSistema = idSistema;
	}
	
}
