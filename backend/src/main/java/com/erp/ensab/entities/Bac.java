package com.erp.ensab.entities;
import lombok.*;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@ToString
@Document(collection = "Bac")
public class Bac  {


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

}
