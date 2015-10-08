package com.github.gherkin.service;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.github.gherkin.api.data.Club;
import com.github.gherkin.api.data.Person;
import com.github.gherkin.entity.ClubEntity;
import com.github.gherkin.persistence.DAO;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class ClubServiceImpl extends GenericService<ClubEntity, Club> implements ClubService {

    @Inject
    private void setDAO(DAO<ClubEntity> dao) {
    this.dao = dao;
    }
    @Inject
    private PersonService personService;

    public Person retrieveMember(Long id) {

        return personService.retrieve(id);
    }

    public List<Club> search(String name) {

        return entityToData(dao.find(name));
    }

    @Override
    protected Club entityToData(ClubEntity clubEntity) {

        Club club;
        List<Person> members;
        Long[] memberIDs;
        Person member;

        members = new ArrayList<Person>();
        memberIDs = clubEntity.getMembers();
        for(Long id : memberIDs) {
            member = personService.retrieve(id);
            members.add(member);
        }

        club = new Club();
        club.setId(clubEntity.getId());
        club.setName(clubEntity.getName());
        club.setMembers(members);

        return club;
    }

    @Override
    protected ClubEntity dataToEntity(Club club) {

        ClubEntity clubEntity;
        Long[] memberIDs;
        List<Person> members;

        members = club.getMembers();
        memberIDs = new Long[members.size()];
        for(int i = 0; i < members.size(); i++)
            memberIDs[i] = members.get(i).getId();

        clubEntity = new ClubEntity();
        clubEntity.setId(club.getId());
        clubEntity.setName(club.getName());
        clubEntity.setMembers(memberIDs);

        return clubEntity;
    }
}
