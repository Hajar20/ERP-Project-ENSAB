package com.erp.ensab.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import com.erp.ensab.entities.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name="Candidate")
public class Candidate implements Serializable {
	public Candidate() {
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ID;

	@JsonIgnore
	@ManyToOne(targetEntity=com.erp.ensab.entities.Major.class, fetch=FetchType.LAZY)
	@JoinColumn(name = "MajorID")
	private Major major;
	
	@Column
	private String cne;
	
	@Column
	private String firstname;
	
	@Column
	private String lastname;
	
	@Column
	private Date birthdate;
	
	@Column
	private String cni;
	
	@Column(length=10)
	private long phone;
	
	@Column
	private char sexe ;
	
	@OneToMany(mappedBy="candidate", targetEntity=com.erp.ensab.entities.Degree.class, fetch=FetchType.LAZY,cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	private List<Degree> degrees = new ArrayList<>();
	
	@OneToOne(mappedBy="candidate", targetEntity=com.erp.ensab.entities.Bac.class, fetch=FetchType.LAZY,cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
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

	private void setID(long value) {
		this.ID = value;
	}
	
	public long getID() {
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
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
