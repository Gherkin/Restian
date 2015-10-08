package com.github.gherkin.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CLUB")
public class ClubEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String members;

    public ClubEntity() {

        this.members = "";
    }

    public ClubEntity(Long id, String name) {

        this.id = id;
        this.name = name;
        this.members = "";
    }

    public ClubEntity(Long id, String name, Long[] memberIDs) {

        this.id = id;
        this.name = name;
        this.members = "";
        setMembers(memberIDs);
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

    public Long[] getMembers() {

        Long[] ids;

        if(!members.equals("")) {
            String[] idString = members.split(",");
            ids = new Long[idString.length];

            for (int i = 0; i < idString.length; i++)
                ids[i] = Long.parseLong(idString[i]);
        }
        else
            ids = new Long[0];

        return ids;
    }

    public void setMembers(Long[] membersIDs) {

        for(Long memberID : membersIDs)
            members += memberID + ",";
    }

    public void addMember(PersonEntity member) {

        members += member.getId() + ",";
    }
}
