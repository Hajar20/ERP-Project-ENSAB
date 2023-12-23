package com.erp.ensab.entities;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
@AllArgsConstructor
@Builder
public class Bac  {


	@Id
	private String ID;

	@DBRef
	private Candidate candidate;
	
	private String type;
	
	private String option;
	
	private Date dateObtaining;
	
	private String distinction;



}
