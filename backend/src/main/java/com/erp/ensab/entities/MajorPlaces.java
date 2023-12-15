package com.erp.ensab.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
@Entity
@Table(name="MajorPlaces")
public class MajorPlaces implements Serializable {
	public MajorPlaces() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@JsonIgnore
	@ManyToOne(targetEntity=com.erp.ensab.entities.Criteria.class, fetch=FetchType.LAZY)
	@JoinColumn(name="CriteriaID")
	private Criteria criteria;

	@Column
	private String name;
	
	@Column
	private int places;

	public MajorPlaces(Criteria criteria, String name, int places) {
		this.criteria = criteria;
		this.name = name;
		this.places = places;
	}

	private void setId(long value) {
		this.id = value;
	}
	
	public long getId() {
		return id;
	}
	

	public void setName(String value) {
		this.name = value;
	}
	
	public String getName() {
		return name;
	}
	
	public void setPlaces(int value) {
		this.places = value;
	}
	
	public int getPlaces() {
		return places;
	}
	
	public void setCriteria(Criteria value) {
		this.criteria = value;
	}
	
	public Criteria getCriteria() {
		return criteria;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
