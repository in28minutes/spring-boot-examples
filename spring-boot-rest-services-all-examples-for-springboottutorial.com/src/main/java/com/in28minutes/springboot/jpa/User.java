package com.in28minutes.springboot.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;
	private String role;

	protected User() {
	}

	public User(String name, String role) {
		super();
		this.name = name;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getRole() {
		return role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", role=" + role + "]";
	}

}
