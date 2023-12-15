package com.erp.ensab.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.*;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Document(collection = "candidates")
public class Candidate {

	@Id
	private String ID; // Changed to String for MongoDB ObjectId compatibility

	@DBRef
	private Major major;
	@Indexed(unique = true)
	private String cne;

	private String firstname;

	private String lastname;

	private Date birthdate;

	private String cni;

	private long phone;

	private char sexe;

	@DBRef
	private List<Degree> degrees=new ArrayList<>();

	private Bac bac;

	public Candidate(Major major, String cne, String firstname, String lastname, Date birthdate, String cni, long phone, char sexe, Bac bac) {
		this.major = major;
		this.cne = cne;
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthdate = birthdate;
		this.cni = cni;
		this.phone = phone;
		this.sexe = sexe;
		this.bac = bac;
	}

	
}
