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
import java.util.Map;

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

	@DBRef(lazy = false)
	private Responsable responsable;

	private int year = new Date().getYear()+1900;

	private Date startDate;

	private Date endDate;

	private float threshold1;

	private float threshold2;

	private float threshold3;

	private String details;

	private String link = "http://localhost:4200/inscription";
	private Date publisDate = new Date();
	//@DBRef
	//private List<MajorPlaces> majorPlaces=new ArrayList<>();

	private List<Map<String,String>> majorPlaces = new ArrayList<>();

	public Criteria(Responsable responsable, Date startDate, Date endDate,
					float threshold1, float threshold2, float threshold3, String details,List<Map<String,String>> majorPlaces ) {
		//this.link = link;
		this.responsable = responsable;
		//this.year = new Date().getYear();
		this.startDate = startDate;
		this.endDate = endDate;
		this.threshold1 = threshold1;
		this.threshold2 = threshold2;
		this.threshold3 = threshold3;
		this.details = details;
		this.majorPlaces = majorPlaces;
		//this.publisDate = new Date();
	}

}
