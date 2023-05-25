package com.api.bbmnet.form;

import java.util.Objects;

import jakarta.validation.constraints.NotNull;

public class EditalForm {

	private Long id;
	
	private Integer chaveEdital;
	
	private Long numeroPregao;
	
	private Integer lote;
	
	@NotNull
	private Long idSistema;

	public Long getId() {
		return id;
	}

	public Integer getChaveEdital() {
		return chaveEdital;
	}

	public Long getNumeroPregao() {
		return numeroPregao;
	}

	public Integer getLote() {
		return lote;
	}

	public Long getIdSistema() {
		return idSistema;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setChaveEdital(Integer chaveEdital) {
		this.chaveEdital = chaveEdital;
	}

	public void setNumeroPregao(Long numeroPregao) {
		this.numeroPregao = numeroPregao;
	}

	public void setLote(Integer lote) {
		this.lote = lote;
	}

	public void setIdSistema(Long idSistema) {
		this.idSistema = idSistema;
	}

	@Override
	public int hashCode() {
		return Objects.hash(chaveEdital, id, idSistema, lote, numeroPregao);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EditalForm other = (EditalForm) obj;
		return Objects.equals(chaveEdital, other.chaveEdital) && Objects.equals(id, other.id)
				&& Objects.equals(idSistema, other.idSistema) && Objects.equals(lote, other.lote)
				&& Objects.equals(numeroPregao, other.numeroPregao);
	}
	
}
