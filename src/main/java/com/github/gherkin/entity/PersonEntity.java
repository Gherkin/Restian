package com.github.gherkin.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PERSON")
public class PersonEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;

	public PersonEntity() {

	}

	public PersonEntity(Long id, String name) {

		this.id = id;
		this.name = name;
	}

	public Long getId() {

		return id;
	}

	public void setId(Long id) {

		this.id = id;
	}

	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}
}
