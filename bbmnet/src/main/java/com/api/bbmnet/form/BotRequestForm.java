package com.api.bbmnet.form;

import java.util.List;
import java.util.Objects;

import com.api.bbmnet.entity.CredenciaisEntity;
import com.api.bbmnet.entity.EditalEntity;

public class BotRequestForm {

	private EditalEntity edital;
	
	private List<CredenciaisEntity> credencial;

	public EditalEntity getEdital() {
		return edital;
	}

	public List<CredenciaisEntity> getCredencial() {
		return credencial;
	}

	public void setEdital(EditalEntity edital) {
		this.edital = edital;
	}

	public void setCredencial(List<CredenciaisEntity> credencial) {
		this.credencial = credencial;
	}

	@Override
	public int hashCode() {
		return Objects.hash(credencial, edital);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BotRequestForm other = (BotRequestForm) obj;
		return Objects.equals(credencial, other.credencial) && Objects.equals(edital, other.edital);
	}
	
}
