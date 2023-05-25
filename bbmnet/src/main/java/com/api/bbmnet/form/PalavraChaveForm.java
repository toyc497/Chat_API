package com.api.bbmnet.form;

public class PalavraChaveForm {

	private Long id;
	private String palavra;
	private String beepName;
	private Long idColorGroup;
	
	public Long getId() {
		return id;
	}
	public String getPalavra() {
		return palavra;
	}
	public String getBeepName() {
		return beepName;
	}
	public Long getIdColorGroup() {
		return idColorGroup;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setPalavra(String palavra) {
		this.palavra = palavra;
	}
	public void setBeepName(String beepName) {
		this.beepName = beepName;
	}
	public void setIdColorGroup(Long idColorGroup) {
		this.idColorGroup = idColorGroup;
	}
	
}
