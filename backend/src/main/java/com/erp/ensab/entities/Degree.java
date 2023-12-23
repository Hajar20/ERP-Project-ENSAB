package com.erp.ensab.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Document(collection = "degrees")
@AllArgsConstructor
@Builder
public class Degree {
	@Id
	private String ID; // Changed to String for MongoDB ObjectId compatibility

	@DBRef
	private Candidate candidate;

	private String type; // DUT ou DUEG ...

	private String speciality; // GI ,Energie ...

	private String degreeType; // Bac+2 ou Bac+3

	private Date diplomaDate;

	private float s1;

	private float s2;

	private float s3;

	private float s4;

	private float s5;

	private float s6;

	private String college;


}
