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
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="palavrachave")
public class PalavraChaveEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="palavra")
	@NotBlank
	private String palavra;
	
	@Column(name="beep_name")
	private String beepName;
	
	@ManyToOne
	@JoinColumn(name="colorgroup_id")
	private ColorGroupEntity colorGroup;

	public Long getId() {
		return id;
	}

	public String getPalavra() {
		return palavra;
	}

	public String getBeepName() {
		return beepName;
	}

	public ColorGroupEntity getColorGroup() {
		return colorGroup;
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

	public void setColorGroup(ColorGroupEntity colorGroup) {
		this.colorGroup = colorGroup;
	}

	@Override
	public int hashCode() {
		return Objects.hash(beepName, colorGroup, id, palavra);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PalavraChaveEntity other = (PalavraChaveEntity) obj;
		return Objects.equals(beepName, other.beepName) && Objects.equals(colorGroup, other.colorGroup)
				&& Objects.equals(id, other.id) && Objects.equals(palavra, other.palavra);
	}
	
}
