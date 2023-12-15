package com.erp.ensab.entities;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@ToString
@Document(collection = "Major")
public class Major {
	@Id
	private String ID;

	private String name;

	@DBRef
	private List<Candidate> candidates = new ArrayList<>();

	public Major(String name) {
		this.name = name;
	}


}
