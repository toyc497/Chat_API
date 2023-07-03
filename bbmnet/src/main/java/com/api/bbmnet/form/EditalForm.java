package com.api.bbmnet.form;

import java.util.Objects;

import jakarta.validation.constraints.NotNull;

public class EditalForm {

	private Long id;
	
	private String chaveEdital;
	
	private Long numeroPregao;
	
	private String orgao;
	
	private Integer lote;
	
	@NotNull
	private Long idSistema;

	public Long getId() {
		return id;
	}

	public String getChaveEdital() {
		return chaveEdital;
	}

	public Long getNumeroPregao() {
		return numeroPregao;
	}

	public String getOrgao() {
		return orgao;
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

	public void setChaveEdital(String chaveEdital) {
		this.chaveEdital = chaveEdital;
	}

	public void setNumeroPregao(Long numeroPregao) {
		this.numeroPregao = numeroPregao;
	}

	public void setOrgao(String orgao) {
		this.orgao = orgao;
	}

	public void setLote(Integer lote) {
		this.lote = lote;
	}

	public void setIdSistema(Long idSistema) {
		this.idSistema = idSistema;
	}

	@Override
	public int hashCode() {
		return Objects.hash(chaveEdital, id, idSistema, lote, numeroPregao, orgao);
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
				&& Objects.equals(numeroPregao, other.numeroPregao) && Objects.equals(orgao, other.orgao);
	}
	
}
