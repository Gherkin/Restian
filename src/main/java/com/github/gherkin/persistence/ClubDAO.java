package com.github.gherkin.persistence;

import java.util.List;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.github.gherkin.entity.ClubEntity;

@Singleton
public class ClubDAO extends GenericDAO<ClubEntity>implements DAO<ClubEntity> {

	public ClubEntity retrieve(Long id) {

		return retrieve(ClubEntity.class, id);
	}

	public List<ClubEntity> retrieveAll() {

		return retrieveAll("SELECT e FROM ClubEntity e", ClubEntity.class);
	}
	
	public void remove(Long id) throws Exception {

		remove(ClubEntity.class, id);
		
	}

    public List<ClubEntity> find(Object name) throws IllegalArgumentException {

        if(!(name instanceof String))
            throw new IllegalArgumentException();

        return find(name, "name", ClubEntity.class);
    }
}
