package com.app.service;

import com.app.dto.PersonDto;
import com.app.model.Person;
import com.app.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PersonService2 {
    @Autowired
    private PersonRepository personRepository;

    public void create(PersonDto person) {
        Person p = fromDto(person);
        personRepository.save(p);
    }

    public List<PersonDto> findAllByName(String name) {

        return toDto(personRepository.findAllByName(name));
    }


    public List<PersonDto> findAllByNameAndAge(String name, int age) {
        return toDto(personRepository.findAllByNameAndAge(name, age));
    }

    public long nativeCount(String name, int age) {
        return personRepository.nativeCount(name, age);
    }

    public long jpaCount(String name, int age) {
        return personRepository.jpaCount(name, age);
    }

    public void nativeRemoveByNameAndAge(String name, int age) {
        personRepository.nativeRemoveByNameAndAge(name, age);
    }

    public PersonDto findById(int id){
        return toDto(personRepository.findById(id).get());
    }

    public void jpaRemoveByNameAndAge(String name, int age) {
        personRepository.jpaRemoveByNameAndAge(name, age);
    }

    public void update(int id, PersonDto candidate){
        Person person = personRepository.findById(id).get();
        person.setName(candidate.getName());
        person.setAge(candidate.getAge());
        personRepository.save(person);
    }

    public void deleteById(int id){
        personRepository.deleteById(id);
    }

    public void deleteAll(){
        personRepository.deleteAll();
    }

    public List<PersonDto> findAll() {
        return toDto(personRepository.findAll());
    }


    public List<PersonDto> findAll(Pageable pageable) {
        Page<Person> result = personRepository.findAll(pageable);
        return toDto(result.getContent());
    }


    private Person fromDto(PersonDto personDto){
        Person person = new Person();
        person.setAge(personDto.getAge());
        person.setName(personDto.getName());
        return person;
    }

    private PersonDto toDto(Person person){
        PersonDto personDto = new PersonDto();
        personDto.setAge(person.getAge());
        personDto.setName(person.getName());
        return personDto;
    }


    private List<PersonDto> toDto(List<Person>  persons){
        List<PersonDto> list = new ArrayList<>();
        for(Person p:persons){
            list.add(toDto(p));
        }

        return list;
    }




}
