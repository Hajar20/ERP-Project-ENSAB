package com.erp.ensab.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document(collection = "Criteria")
public class Criteria  {
	public Criteria() {
	}
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

	private void setID(String value) {
		this.ID = value;
	}
	
	public String getID() {
		return ID;
	}

	public void setYear(int value) {
		this.year = value;
	}
	
	public int getYear() {
		return year;
	}

	
	public void setStartDate(Date value) {
		this.startDate = value;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	
	public void setEndDate(java.util.Date value) {
		this.endDate = value;
	}
	
	public Date getEndDate() {
		return endDate;
	}
	
	public void setThreshold1(float value) {
		this.threshold1 = value;
	}
	
	public float getThreshold1() {
		return threshold1;
	}
	
	public void setThreshold2(float value) {
		this.threshold2 = value;
	}
	
	public float getThreshold2() {
		return threshold2;
	}
	
	public void setThreshold3(float value) {
		this.threshold3 = value;
	}
	
	public float getThreshold3() {
		return threshold3;
	}
	
	public void setDetails(String value) {
		this.details = value;
	}
	
	public String getDetails() {
		return details;
	}
	
	public void setResponsable(Responsable value) {
		this.responsable = value;
	}
	
	public Responsable getResponsable() {
		return responsable;
	}
	
	public void setMajorPlaces(List<MajorPlaces> value) {
		this.majorPlaces = value;
	}
	
	public List<MajorPlaces> getMajorPlaces() {
		return majorPlaces;
	}

	@Override
	public String toString() {
		return "Criteria{" +
				"ID='" + ID + '\'' +
				", responsable=" + responsable +
				", year=" + year +
				", startDate=" + startDate +
				", endDate=" + endDate +
				", threshold1=" + threshold1 +
				", threshold2=" + threshold2 +
				", threshold3=" + threshold3 +
				", details='" + details + '\'' +
				", majorPlaces=" + majorPlaces +
				'}';
	}

	
}
