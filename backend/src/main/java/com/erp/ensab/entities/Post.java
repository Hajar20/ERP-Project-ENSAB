package com.erp.ensab.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
@Entity
@Table(name="Post")
public class Post implements Serializable {
	public Post() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ID;

	@JsonIgnore
	@ManyToOne(targetEntity=com.erp.ensab.entities.Responsable.class, fetch=FetchType.LAZY)
	@JoinColumn(name="ResponsableID")
	private Responsable responsable;
	
	@Column
	private String title;
	
	@Column
	private String details;
	
	@Column
	private String file;

	public Post(Responsable responsable, String title, String details, String file) {
		this.responsable = responsable;
		this.title = title;
		this.details = details;
		this.file = file;
	}

	private void setID(long value) {
		this.ID = value;
	}
	
	public long getID() {
		return ID;
	}
	

	public void setTitle(String value) {
		this.title = value;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setDetails(String value) {
		this.details = value;
	}
	
	public String getDetails() {
		return details;
	}
	
	public void setFile(String value) {
		this.file = value;
	}
	
	public String getFile() {
		return file;
	}
	
	public void setResponsable(Responsable value) {
		this.responsable = value;
	}
	
	public Responsable getResponsable() {
		return responsable;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
