package com.api.bbmnet.form;

import java.util.Objects;

public class MensagemForm {

	private Long id;
	
	private String origem;
	
	private String dataHora;
	
	private String conteudo;
	
	private Long idEdital;

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

	public Long getIdEdital() {
		return idEdital;
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

	public void setIdEdital(Long idEdital) {
		this.idEdital = idEdital;
	}

	@Override
	public int hashCode() {
		return Objects.hash(conteudo, dataHora, id, idEdital, origem);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MensagemForm other = (MensagemForm) obj;
		return Objects.equals(conteudo, other.conteudo) && Objects.equals(dataHora, other.dataHora)
				&& Objects.equals(id, other.id) && Objects.equals(idEdital, other.idEdital)
				&& Objects.equals(origem, other.origem);
	}
	
}
