package com.erp.ensab.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Document(collection = "degrees")
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

	public Degree(Candidate candidate, String type, String degreeType, String speciality, Date diplomaDate, float s1, float s2, float s3, float s4, float s5, float s6, String college) {
		this.candidate = candidate;
		this.type = type;
		this.speciality = speciality;
		this.diplomaDate = diplomaDate;
		this.s1 = s1;
		this.s2 = s2;
		this.s3 = s3;
		this.s4 = s4;
		this.s5 = s5;
		this.s6 = s6;
		this.college = college;
		this.degreeType=degreeType;
	}

}
