package com.github.gherkin.persistence;

import java.util.Collection;

import javax.inject.Singleton;

import com.github.gherkin.entity.ClubEntity;

@Singleton
public class ClubDAO extends GenericDAO<ClubEntity>implements DAO<ClubEntity> {

	public ClubEntity retrieve(Long id) {
		return retrieve(ClubEntity.class, id);
	}

	public Collection<ClubEntity> retrieveAll() {
		return retrieveAll("SELECT e FROM ClubEntity e", ClubEntity.class);
	}
	
	public void remove(Long id) throws Exception {
		remove(ClubEntity.class, id);
		
	}

}
