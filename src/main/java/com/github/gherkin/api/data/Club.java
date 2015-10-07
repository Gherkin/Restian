package com.github.gherkin.api.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by niyohn on 10/6/15.
 */
public class Club extends Data {

    private Long id;
    private String name;
    private List<Person> members;

    public Club() {

        this.members = new ArrayList<Person>();
    }

    public Club(Long id, String name) {

        this.id = id;
        this.name = name;
        this.members = new ArrayList<Person>();
    }

    public Club(Long id, String name, List<Person> members) {

        this.id = id;
        this.name = name;
        this.members = members;
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

    public List<Person> getMembers() {

        return members;
    }

    public void setMembers(List<Person> members) {

        this.members = members;
    }

    public Person getMember(int id) {

        return members.get(id);
    }

    public void addMember(Person person) {

        members.add(person);
    }

    public void removeMember(int id) {

        members.remove(id);
    }
}
