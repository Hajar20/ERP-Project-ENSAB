package com.erp.ensab.entities;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.*;
import java.util.*;

@Document(collection = "Candidate")
public class Candidate {
	public Candidate() {
	}

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

	private void setID(String value) {
		this.ID = value;
	}
	
	public String getID() {
		return ID;
	}

	
	public void setCne(String value) {
		this.cne = value;
	}
	
	public String getCne() {
		return cne;
	}
	
	public void setFirstname(String value) {
		this.firstname = value;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setLastname(String value) {
		this.lastname = value;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public void setBirthdate(java.util.Date value) {
		this.birthdate = value;
	}
	
	public Date getBirthdate() {
		return birthdate;
	}
	
	public void setCni(String value) {
		this.cni = value;
	}
	
	public String getCni() {
		return cni;
	}
	
	public void setPhone(long value) {
		this.phone = value;
	}
	
	public long getPhone() {
		return phone;
	}
	
	public void setSexe(char value) {
		this.sexe = value;
	}
	
	public char getSexe() {
		return sexe;
	}
	
	public void setDegrees(List<Degree> value) {
		this.degrees = value;
	}
	
	public List<Degree> getDegrees() {
		return degrees;
	}
	
	
	public void setMajor(Major value) {
		this.major = value;
	}
	
	public Major getMajor() {
		return major;
	}
	
	public void setBac(Bac value) {
		this.bac = value;
	}
	
	public Bac getBac() {
		return bac;
	}
	
	@Override
	public String toString() {
		return "Candidate{" +
				"ID='" + ID + '\'' +
				", major=" + major +
				", cne='" + cne + '\'' +
				", firstname='" + firstname + '\'' +
				", lastname='" + lastname + '\'' +
				", birthdate=" + birthdate +
				", cni='" + cni + '\'' +
				", phone=" + phone +
				", sexe=" + sexe +
				", degrees=" + degrees +
				", bac=" + bac +
				'}';
	}
	
}
