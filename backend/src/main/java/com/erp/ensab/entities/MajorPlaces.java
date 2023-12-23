package com.erp.ensab.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Document(collection = "majorPlaces")
@AllArgsConstructor
@Builder
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
