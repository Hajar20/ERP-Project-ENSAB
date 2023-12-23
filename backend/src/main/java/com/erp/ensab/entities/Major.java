package com.erp.ensab.entities;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@ToString
@Document(collection = "majors")
@Builder
@AllArgsConstructor
public class Major {
	@Id
	private String ID;


	private String name;

	@DBRef
	private List<Candidate> candidates = new ArrayList<>();



}
