package com.erp.ensab.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Document(collection = "criterias")
@AllArgsConstructor
@Builder
public class Criteria  {
	@Id
	private String ID; // Changed to String for MongoDB ObjectId compatibility

	@DBRef
	private Responsable responsable;

	private int year;

	private Date startDate;

	private Date endDate;

	private float threshold1;

	private float threshold2;

	private float threshold3;

	private String details;

	@DBRef
	private List<MajorPlaces> majorPlaces=new ArrayList<>();

}
