package com.github.gherkin.api;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.github.gherkin.api.data.Person;
import com.github.gherkin.service.PersonService;

@Path("/Person")
public class PersonResource {

    @Inject
    private PersonService personService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getAll() {

        return personService.retrieveAll();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Person addPerson(@QueryParam("name") String name, @QueryParam("id") Long id) {

        Person person = new Person(id, name);

        personService.add(person);

        return person;
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Person deletePerson(@PathParam("id") Long id) throws Exception {

        Person person;
        person = personService.retrieve(id);

        personService.delete(person);

        return person;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Person getPersonByID(@PathParam("id") Long id) {

        return personService.retrieve(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("search")
    public List<Person> searchForPerson(@QueryParam("name") String name) {
        System.out.println("searching for '" + name + "'");
        return personService.search(name);
    }
}
