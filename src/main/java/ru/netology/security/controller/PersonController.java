package ru.netology.hibernate.controller;

import ru.netology.hibernate.model.Person;
import ru.netology.hibernate.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class PersonController {
    private PersonService personService;
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/by-city")
    public List<Person> getPersonsByCity(String city) {
        return personService.getPersonsByCity(city);
    }

    @GetMapping("/by-age-less-than")
    public List<Person> getPersonsByAgeLessThan(int age) {
        return personService.getPersonsByAgeLessThan(age);
    }

    @GetMapping("/by-name-and-surname")
    public Optional<Person> getPersonByNameAndSurname(String name, String surname) {
        return personService.getPersonByNameAndSurname(name, surname);
    }
}
