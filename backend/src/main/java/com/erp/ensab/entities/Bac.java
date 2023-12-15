package com.erp.ensab.entities;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "Bac")
public class Bac  {
	public Bac() {
	}

	@Id
	private String ID;

	@DBRef
	private Candidate candidate;
	
	private String type;
	
	private String option;
	
	private Date dateObtaining;
	
	private String distinction;

	public Bac(Candidate candidate, String type, String option, Date dateObtaining, String distinction) {
		this.candidate = candidate;
		this.type = type;
		this.option = option;
		this.dateObtaining = dateObtaining;
		this.distinction = distinction;
	}

	private void setID(String value) {
		this.ID = value;
	}
	
	public String getID() {
		return ID;
	}
	

	
	public void setType(String value) {
		this.type = value;
	}
	
	public String getType() {
		return type;
	}
	
	public void setOption(String value) {
		this.option = value;
	}
	
	public String getOption() {
		return option;
	}
	
	public void setDateObtaining(java.util.Date value) {
		this.dateObtaining = value;
	}
	
	public java.util.Date getDateObtaining() {
		return dateObtaining;
	}
	
	public void setDistinction(String value) {
		this.distinction = value;
	}
	
	public String getDistinction() {
		return distinction;
	}
	
	public void setCandidate(Candidate value) {
		this.candidate = value;
	}
	
	public Candidate getCandidate() {
		return candidate;
	}
	
	@Override
	public String toString() {
		return "Bac{" +
				"ID='" + ID + '\'' +
				", candidate=" + candidate +
				", type='" + type + '\'' +
				", option='" + option + '\'' +
				", dateObtaining=" + dateObtaining +
				", distinction='" + distinction + '\'' +
				'}';
	}
	
}
