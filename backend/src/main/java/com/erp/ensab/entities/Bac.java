package com.erp.ensab.entities;
import jakarta.persistence.*;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="Bac")
public class Bac implements Serializable {
	public Bac() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ID;
	
	@OneToOne(targetEntity=com.erp.ensab.entities.Candidate.class, fetch=FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name="CandidateID") })
	private Candidate candidate;
	
	@Column
	private String type;
	
	@Column
	private String option;
	
	@Column
	private Date dateObtaining;
	
	@Column
	private String distinction;

	public Bac(Candidate candidate, String type, String option, Date dateObtaining, String distinction) {
		this.candidate = candidate;
		this.type = type;
		this.option = option;
		this.dateObtaining = dateObtaining;
		this.distinction = distinction;
	}

	private void setID(long value) {
		this.ID = value;
	}
	
	public long getID() {
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
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
