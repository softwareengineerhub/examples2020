package com.app.rest.api;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/*
Safety - при вызове метода не удаляются данные
Get

Idenpotency - при вызове метода c одними параметрами результат всегда одинаковый
POST - не idenpotent

GET?id=1
DELETE?id=1

 */


@WebServlet(name = "personServlet", urlPatterns = {"/person"})
public class PersonServlet extends HttpServlet {
    @Resource(name = "personDS")
    private DataSource ds;
    private PersonDao personDao;
    private ObjectMapper objectMapper;

    public void init() {
        personDao = new PersonDao(ds);
        objectMapper = new ObjectMapper();
    }


    //create
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Person person = readPerson(request);
        personDao.create(person);
    }

    //read
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        response.setContentType("application/json");
        if (id == null) {
            List<Person> list = personDao.readAll();
            writePerson(response, list);
        } else {
            Person person = personDao.read(Integer.parseInt(id));
            writePerson(response, person);
        }
    }

    //update
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        if (id != null) {
            Person person = readPerson(request);
            personDao.update(person, Integer.parseInt(id));
        }
    }

    //delete
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id != null) {
            personDao.delete(Integer.parseInt(id));
        }
    }

    private Person readPerson(HttpServletRequest request) {
        try {
            ServletInputStream in = request.getInputStream();
            Person person = objectMapper.readValue(in, Person.class);
            return person;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private void writePerson(HttpServletResponse response, Person person) {
        try {
            OutputStream out = response.getOutputStream();
            String json = objectMapper.writeValueAsString(person);
            out.write(json.getBytes());
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }


    private void writePerson(HttpServletResponse response, List<Person> persons) {
        try {
            OutputStream out = response.getOutputStream();
            String json = objectMapper.writeValueAsString(persons);
            out.write(json.getBytes());
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }


}
