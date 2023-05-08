package com.api.bbmnet.form;

import java.util.ArrayList;
import java.util.List;

public class SistemaForm {
	
	private String nome;
	
	private List<CredenciaisForm> credenciais = new ArrayList<>();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<CredenciaisForm> getCredenciais() {
		return credenciais;
	}

	public void setCredenciais(List<CredenciaisForm> credenciais) {
		this.credenciais = credenciais;
	}
	
}
