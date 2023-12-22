package com.erp.ensab.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Document(collection = "majorPlaces")
public class MajorPlaces {
	@Id
	private String id;

	@DBRef
	private Criteria criteria;

	private String name;

	private int places;

	public MajorPlaces(String name, int places) {
		this.criteria = criteria;
		this.name = name;
		this.places = places;
	}

}
