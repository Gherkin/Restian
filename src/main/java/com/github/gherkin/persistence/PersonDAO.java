package com.github.gherkin.persistence;

import java.util.List;

import javax.inject.Singleton;

import com.github.gherkin.entity.PersonEntity;


@Singleton
public class PersonDAO extends GenericDAO<PersonEntity> implements DAO<PersonEntity>{
	
	public PersonEntity retrieve(Long id) {

		return retrieve(PersonEntity.class, id);
	}

	public List<PersonEntity> retrieveAll() {

		return retrieveAll("SELECT e FROM PersonEntity e", PersonEntity.class);	
	}
	
	public void remove(Long id) throws Exception {

		remove(PersonEntity.class, id);
	}
}
