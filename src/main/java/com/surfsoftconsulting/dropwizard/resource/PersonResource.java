package com.surfsoftconsulting.dropwizard.resource;

import com.surfsoftconsulting.dropwizard.repository.Person;
import com.surfsoftconsulting.dropwizard.repository.PersonDAO;
import io.dropwizard.hibernate.UnitOfWork;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.UUID;

@Path("/people")
@Produces(MediaType.APPLICATION_JSON)
public class PersonResource {

    private final PersonDAO peopleDAO;

    public PersonResource(PersonDAO peopleDAO) {
        this.peopleDAO = peopleDAO;
    }

    @GET
    @UnitOfWork
    @Path("/{personId}")
    public Person getPerson(@PathParam("personId") UUID personId) {
        return peopleDAO.findById(personId).orElseThrow(() -> new NotFoundException("No such user."));
    }

    @POST
    @UnitOfWork
    public UUID createPerson(@NotNull PersonRequest personRequest) {
        Person person = new Person(personRequest.getFullName(), personRequest.getJobTitle(), personRequest.getYearBorn());
        return peopleDAO.create(person).getId();
    }

}