package com.erp.ensab.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Document(collection = "Criteria")
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

	public Criteria(int year, Date startDate, Date endDate,
					float threshold1, float threshold2, float threshold3, String details) {
		this.year = year;
		this.startDate = startDate;
		this.endDate = endDate;
		this.threshold1 = threshold1;
		this.threshold2 = threshold2;
		this.threshold3 = threshold3;
		this.details = details;
	}

}
