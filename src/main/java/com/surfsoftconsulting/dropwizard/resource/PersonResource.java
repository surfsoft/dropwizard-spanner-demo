package com.surfsoftconsulting.dropwizard.resource;

import com.surfsoftconsulting.dropwizard.repository.Person;
import com.surfsoftconsulting.dropwizard.repository.PersonDAO;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.OptionalLong;

@Path("/people/{personId}")
@Produces(MediaType.APPLICATION_JSON)
public class PersonResource {

    private final PersonDAO peopleDAO;

    public PersonResource(PersonDAO peopleDAO) {
        this.peopleDAO = peopleDAO;
    }

    @GET
    @UnitOfWork
    public Person getPerson(@PathParam("personId") OptionalLong personId) {
        return findSafely(personId.getAsLong());
    }

    private Person findSafely(long personId) {
        return peopleDAO.findById(personId).orElseThrow(() -> new NotFoundException("No such user."));
    }

}