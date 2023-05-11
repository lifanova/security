package ru.netology.hibernate.service;

import org.springframework.data.domain.Sort;
import ru.netology.hibernate.model.Person;
import org.springframework.stereotype.Service;
import ru.netology.hibernate.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getPersonsByCity(String city) {
        return personRepository.findAllByCityOfLivingEquals(city);
    }

    public List<Person> getPersonsByAgeLessThan(int age) {
        return personRepository.findAllByAgeIsLessThan(age, Sort.by("age"));
    }

    public Optional<Person> getPersonByNameAndSurname(String name, String surname) {
        return  personRepository.findByNameEqualsAndSurnameEquals(name, surname);
    }

}
