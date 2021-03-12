package com.afigueredo.easy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "parameters")
public class Parameter {

	private Long id;
	private String modeCalculateObjectives;
	private String modeTheme;
	
	public Parameter() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(generator = "parameter_seq", strategy = GenerationType.SEQUENCE)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "mode_calculate_objectives", nullable = false)
	public String getModeCalculateObjectives() {
		return modeCalculateObjectives;
	}


	public void setModeCalculateObjectives(String modeCalculateObjectives) {
		this.modeCalculateObjectives = modeCalculateObjectives;
	}

	@Column(name = "mode_theme", nullable = false)
	public String getModeTheme() {
		return modeTheme;
	}

	public void setModeTheme(String modeTheme) {
		this.modeTheme = modeTheme;
	}

	
	@Override
	public String toString() {
		return "Paramento [id=" + id + ", modeCalculateObjectives=" + modeCalculateObjectives + ", modeTheme="
				+ modeTheme + "]";
	}

}
