package com.github.gherkin.service;

import com.github.gherkin.api.data.Club;
import com.github.gherkin.api.data.Person;

import java.util.List;

public interface ClubService {

    Club retrieve(Long id);
    List<Club> retrieveAll();
    Person retrieveMember(Long id);
    void add(Club club);
    void delete(Club club) throws Exception;
    List<Club> search(String name) throws IllegalArgumentException;
}
