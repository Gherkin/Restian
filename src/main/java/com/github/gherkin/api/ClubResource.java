package com.github.gherkin.api;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.github.gherkin.api.data.Club;
import com.github.gherkin.api.data.Person;
import com.github.gherkin.service.ClubService;

@Path("/Clubs")
public class ClubResource {

    @Inject
    private ClubService clubService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Club> getAll() {

        return clubService.retrieveAll();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Club getClub(@PathParam("id") Long id) {

        System.out.println("id = '" + id + "'");
        return clubService.retrieve(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Club addClub(@QueryParam("name") String name, @QueryParam("id") Long id, @QueryParam("member") List<Long> memberIDs) {

        Club club;
        club = new Club(id, name);

        Person member;
        for(Long memberID : memberIDs) {
            member = clubService.retrieveMember(memberID);
            club.addMember(member);
        }

        clubService.add(club);
        return club;
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Club deleteClub(@PathParam("id") Long id) throws Exception {

        Club club = clubService.retrieve(id);
        clubService.delete(club);

        return club;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("search")
    public List<Club> searchForClub(@QueryParam("name") String name) {

        return clubService.search(name);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}/all")
    public Collection<Person> getClubsMembers(@PathParam("id") Long id) {

        Club club = clubService.retrieve(id);
        return club.getMembers();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}/{memberID}")
    public Person getClubsMember(@PathParam("id") Long id, @PathParam("memberID") int internalMemberID) {

        Club club = clubService.retrieve(id);

        return club.getMember(internalMemberID);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Club addMember(@PathParam("id") Long id, @QueryParam("id") Long memberID) {

        Club club = clubService.retrieve(id);
        Person person = clubService.retrieveMember(memberID);

        club.addMember(person);
        clubService.add(club);

        return club;
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}/{memberID}")
    public Club deleteMember(@PathParam("id") Long id, @PathParam("memberID") int internalMemberID) {

        Club club = clubService.retrieve(id);

        club.removeMember(internalMemberID);
        clubService.add(club);

        return club;

    }
}
