package com.erp.ensab.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "Responsable")
public class Responsable implements Serializable {
	@Id
	private String ID;
	@Indexed(unique = true)
	private String email;
	private String password;
	private String username;

	@DBRef
	private List<Criteria> criterias = new ArrayList<>();

	@DBRef
	private List<Post> posts = new ArrayList<>();

	public Responsable() {
	}

	public Responsable(String email, String password, String username) {
		this.email = email;
		this.password = password;
		this.username = username;
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Criteria> getCriterias() {
		return criterias;
	}

	public void setCriterias(List<Criteria> criterias) {
		this.criterias = criterias;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "Responsable{" +
				"ID='" + ID + '\'' +
				", email='" + email + '\'' +
				", password='" + password + '\'' +
				", username='" + username + '\'' +
				'}';
	}
}
