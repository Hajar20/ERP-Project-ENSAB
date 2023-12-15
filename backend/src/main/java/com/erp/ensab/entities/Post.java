package com.erp.ensab.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "Post")
public class Post implements Serializable {
	@Id
	private String id;

	@DBRef
	private Responsable responsable;

	private String title;
	private String details;
	private String file;

	public Post() {
	}

	public Post(String title, String details, String file) {
		this.title = title;
		this.details = details;
		this.file = file;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Responsable getResponsable() {
		return responsable;
	}

	public void setResponsable(Responsable responsable) {
		this.responsable = responsable;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "Post{" +
				"id='" + id + '\'' +
				", responsable=" + responsable +
				", title='" + title + '\'' +
				", details='" + details + '\'' +
				", file='" + file + '\'' +
				'}';
	}
}
