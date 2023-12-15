package com.erp.ensab.entities;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Major")
public class Major implements Serializable {
	public Major() {
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ID;
	
	@Column
	private String name;
	
	@OneToMany(mappedBy="major", targetEntity=Candidate.class)	
	private List<Candidate> candidates = new ArrayList<>();

	public Major(String name) {
		this.name = name;
	}

	private void setID(long value) {
		this.ID = value;
	}
	
	public long getID() {
		return ID;
	}
	

	public void setName(String value) {
		this.name = value;
	}
	
	public String getName() {
		return name;
	}
	
	public void setCandidates(List<Candidate> value) {
		this.candidates = value;
	}
	
	public List<Candidate> getCandidates() {
		return candidates;
	}
	
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
