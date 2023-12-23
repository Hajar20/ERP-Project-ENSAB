package com.erp.ensab.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Document(collection = "responsables")
@AllArgsConstructor
@Builder
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

	public Responsable(String email, String password, String username) {
		this.email = email;
		this.password = password;
		this.username = username;
	}

}
