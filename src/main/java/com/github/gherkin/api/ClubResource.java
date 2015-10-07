package com.github.gherkin.api;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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

		return clubService.retrieve(id);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}/0")
	public Collection<Person> getClubsMember(@PathParam("id") Long id) {

		Club club = clubService.retrieve(id);
		return club.getMembers();
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
}
