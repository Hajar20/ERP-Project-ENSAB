package com.erp.ensab.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.*;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Document(collection = "candidates")
@Builder
@AllArgsConstructor
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


}
