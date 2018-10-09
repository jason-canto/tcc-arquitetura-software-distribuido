package com.jason.ecommerce.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User implements Serializable {

	private static final long serialVersionUID = -1326358250246152153L;

	@Id
	private String id;

	private String name;

	private String email;

	private String username;

	private String role;

	private String fullName;

	private String password;

	private int age;

	private boolean active;

}
