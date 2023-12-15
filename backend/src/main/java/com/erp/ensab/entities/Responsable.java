package com.erp.ensab.entities;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.*;

@Entity
@Table(name="Responsable")
public class Responsable implements Serializable {
	public Responsable() {
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ID;
	
	@Column
	private String email;
	
	@Column
	private String password;
	
	@Column
	private String username;
	
	@OneToMany(mappedBy="responsable", targetEntity=com.erp.ensab.entities.Criteria.class)
	private List<Criteria> criterias = new ArrayList<>();
	
	@OneToMany(mappedBy="responsable", targetEntity=com.erp.ensab.entities.Post.class)
	private List<Post> posts = new ArrayList<>();

	public Responsable(String email, String password, String username) {
		this.email = email;
		this.password = password;
		this.username = username;
	}

	private void setID(long value) {
		this.ID = value;
	}
	
	public long getID() {
		return ID;
	}
	

	public void setEmail(String value) {
		this.email = value;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setPassword(String value) {
		this.password = value;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setUsername(String value) {
		this.username = value;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setCriterias(List<Criteria> value) {
		this.criterias = value;
	}
	
	public List<Criteria> getCriterias() {
		return criterias;
	}
	
	
	public void setPosts(List<Post> value) {
		this.posts = value;
	}
	
	public List<Post> getPosts() {
		return posts;
	}
	
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
