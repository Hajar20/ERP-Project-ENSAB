package com.erp.ensab.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Document(collection = "MajorPlaces")
public class MajorPlaces {
	@Id
	private String id;

	@DBRef
	private Criteria criteria;

	private String name;

	private int places;

	public MajorPlaces() {
	}

	public MajorPlaces(Criteria criteria, String name, int places) {
		this.criteria = criteria;
		this.name = name;
		this.places = places;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Criteria getCriteria() {
		return criteria;
	}

	public void setCriteria(Criteria criteria) {
		this.criteria = criteria;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPlaces() {
		return places;
	}

	public void setPlaces(int places) {
		this.places = places;
	}

	@Override
	public String toString() {
		return "MajorPlaces{" +
				"id='" + id + '\'' +
				", criteria=" + criteria +
				", name='" + name + '\'' +
				", places=" + places +
				'}';
	}
}
