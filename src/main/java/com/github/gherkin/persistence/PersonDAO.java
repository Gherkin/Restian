package com.github.gherkin.persistence;

import java.util.List;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.Query;

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

	public List<PersonEntity> find(Class<?> name) {
		if(!name.isInstance(String.class))
			throw new IllegalArgumentException();
		EntityManager em = emf.createEntityManager();

		String queryString = String.format("SELECT e FROM PersonEntity e WHERE e.NAME = %d", name);
		Query query = em.createQuery(queryString, PersonEntity.class);

		return query.getResultList();

	}

    public List<PersonEntity> find(Object name) throws IllegalArgumentException {

        if(!(name instanceof String))
            throw new IllegalArgumentException();

        return find(name, "name", PersonEntity.class);
    }
}
