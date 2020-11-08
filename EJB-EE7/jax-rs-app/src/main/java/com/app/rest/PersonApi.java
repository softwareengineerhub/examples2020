package com.app.rest;

import com.app.bean.PersonDao;
import com.app.bean.PersonDaoImpl2;
import com.app.domen.Person;

import javax.ejb.EJB;
import javax.validation.Valid;
import javax.ws.rs.*;
import java.util.List;

@Path("/person")
public class PersonApi {

    @EJB
    private PersonDao personDao;

    @POST
    public void create(@Valid Person person) {
        System.out.println(person);

        personDao.create(person);
    }

    @GET
    @Path("/{id}")
    public Person findById(@PathParam("id") int id) {
        return personDao.findById(id);
    }

    @GET
    public List<Person> findAll() {
        return personDao.findAll();
    }

    @PUT
    @Path("/{id}")
    public void updateById(@PathParam("id") int id, Person person) {
        personDao.update(id, person);
    }

    @DELETE
    @Path("/{id}")
    public void deleteById(@PathParam("id")int id) {
        personDao.deleteById(id);
    }

    @DELETE
    public void deleteAll() {
        personDao.deleteAll();
    }

}
