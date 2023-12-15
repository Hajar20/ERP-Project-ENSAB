package com.erp.ensab.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.*;

import java.util.Date;

@Document(collection = "Degree")
public class Degree {
	public Degree() {
	}

	@Id
	private String ID; // Changed to String for MongoDB ObjectId compatibility

	@DBRef
	private Candidate candidate;

	private String type;

	private String speciality;

	private Date diplomaDate;

	private float s1;

	private float s2;

	private float s3;

	private float s4;

	private float s5;

	private float s6;

	private String college;

	public Degree(Candidate candidate, String type, String speciality, Date diplomaDate, float s1, float s2, float s3, float s4, float s5, float s6, String college) {
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
	}

	private void setID(String value) {
		this.ID = value;
	}
	
	public String  getID() {
		return ID;
	}
	

	public void setType(String value) {
		this.type = value;
	}
	
	public String getType() {
		return type;
	}
	
	public void setSpeciality(String value) {
		this.speciality = value;
	}
	
	public String getSpeciality() {
		return speciality;
	}
	
	public void setDiplomaDate(java.util.Date value) {
		this.diplomaDate = value;
	}
	
	public Date getDiplomaDate() {
		return diplomaDate;
	}
	
	public void setS1(float value) {
		this.s1 = value;
	}
	
	public float getS1() {
		return s1;
	}
	
	public void setS2(float value) {
		this.s2 = value;
	}
	
	public float getS2() {
		return s2;
	}
	
	public void setS3(float value) {
		this.s3 = value;
	}
	
	public float getS3() {
		return s3;
	}
	
	public void setS4(float value) {
		this.s4 = value;
	}
	
	public float getS4() {
		return s4;
	}
	
	public void setS5(float value) {
		this.s5 = value;
	}
	
	public float getS5() {
		return s5;
	}
	
	public void setS6(float value) {
		this.s6 = value;
	}
	
	public float getS6() {
		return s6;
	}
	
	public void setCollege(String value) {
		this.college = value;
	}
	
	public String getCollege() {
		return college;
	}
	
	public void setCandidate(Candidate value) {
		this.candidate = value;
	}
	
	public Candidate getCandidate() {
		return candidate;
	}

	@Override
	public String toString() {
		return "Degree{" +
				"ID='" + ID + '\'' +
				", candidate=" + candidate +
				", type='" + type + '\'' +
				", speciality='" + speciality + '\'' +
				", diplomaDate=" + diplomaDate +
				", s1=" + s1 +
				", s2=" + s2 +
				", s3=" + s3 +
				", s4=" + s4 +
				", s5=" + s5 +
				", s6=" + s6 +
				", college='" + college + '\'' +
				'}';
	}
}
