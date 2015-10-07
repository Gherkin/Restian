package com.github.gherkin.service;

import java.util.List;

import com.github.gherkin.api.data.Person;

public interface PersonService {

	Person retrieve(Long id);
    List<Person> retrieveAll();
	void add(Person person);
	void delete(Person person) throws Exception;
}
