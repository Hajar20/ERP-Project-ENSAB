package com.erp.ensab.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Document(collection = "Post")
public class Post implements Serializable {
	@Id
	private String id;

	@DBRef
	private Responsable responsable;
	private String title;
	private String details;
	private String file;

	public Post(String title, String details, String file) {
		this.title = title;
		this.details = details;
		this.file = file;
	}

}
