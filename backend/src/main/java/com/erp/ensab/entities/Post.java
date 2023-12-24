package com.erp.ensab.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Document(collection = "posts")
@AllArgsConstructor
@Builder
public class Post implements Serializable {
	@Id
	private String id;

	@DBRef
	private Responsable responsable;
	private String title;
	private String details;
	private String file;
	private Date publishDate = new Date();

	public Post(Responsable responsable, String title, String details, String file) {
		this.responsable = responsable;
		this.title = title;
		this.details = details;
		this.file = file;
	}
}
