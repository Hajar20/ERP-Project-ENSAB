package com.erp.ensab.entities;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "Major")
public class Major {
	@Id
	private String ID;

	private String name;

	@DBRef
	private List<Candidate> candidates = new ArrayList<>();

	public Major() {
	}

	public Major(String name) {
		this.name = name;
	}

	private void setID(String value) {
		this.ID = value;
	}
	
	public String getID() {
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


	@Override
	public String toString() {
		return "Major{" +
				"ID='" + ID + '\'' +
				", name='" + name + '\'' +
				", candidates=" + candidates +
				'}';
	}
}
