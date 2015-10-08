package com.github.gherkin.service;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.github.gherkin.api.data.Person;
import com.github.gherkin.entity.PersonEntity;
import com.github.gherkin.persistence.DAO;

import java.util.List;

@Singleton
public class PersonServiceImpl extends GenericService<PersonEntity, Person> implements PersonService {

    @Inject
    private void setDAO(DAO<PersonEntity> dao) {

        this.dao = dao;
    }

    @Override
    protected PersonEntity dataToEntity(Person person) {

        PersonEntity personEntity;

        personEntity = new PersonEntity();
        personEntity.setId(person.getId());
        personEntity.setName(person.getName());

        return personEntity;
    }

    @Override
    protected Person entityToData(PersonEntity personEntity) {

        Person person;

        person = new Person();
        person.setId(personEntity.getId());
        person.setName(personEntity.getName());

        return person;
    }

    public List<Person> search(String name) {

        return entityToData(dao.find(name));
    }
}
