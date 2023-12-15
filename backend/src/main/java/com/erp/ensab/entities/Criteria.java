package com.erp.ensab.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Criteria")
public class Criteria implements Serializable {
	public Criteria() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ID;
	@JsonIgnore
	@ManyToOne(targetEntity=com.erp.ensab.entities.Responsable.class, fetch=FetchType.LAZY)
	@JoinColumn(name = "Responsable")
	private Responsable responsable;
	
	@Column
	private int year;

	@Column
	private Date startDate;
	
	@Column
	private Date endDate;
	
	@Column
	private float threshold1;
	
	@Column
	private float threshold2;
	
	@Column
	private float threshold3;
	
	@Column(length = 2000)
	private String details;
	
	@OneToMany(mappedBy="criteria", targetEntity=com.erp.ensab.entities.MajorPlaces.class, fetch=FetchType.LAZY,cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	private List<MajorPlaces> majorPlaces = new ArrayList<>();

	public Criteria(Responsable responsable, int year, Date startDate, Date endDate, float threshold1, float threshold2, float threshold3, String details) {
		this.responsable = responsable;
		this.year = year;
		this.startDate = startDate;
		this.endDate = endDate;
		this.threshold1 = threshold1;
		this.threshold2 = threshold2;
		this.threshold3 = threshold3;
		this.details = details;
	}

	private void setID(long value) {
		this.ID = value;
	}
	
	public long getID() {
		return ID;
	}
	
	public long getORMID() {
		return getID();
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
	
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
