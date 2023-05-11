package ru.netology.hibernate.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.netology.hibernate.model.Person;
import ru.netology.hibernate.model.PersonId;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, PersonId> {
    @Query("select p from Person p where p.cityOfLiving = :city")
    List<Person> findAllByCityOfLivingEquals(@Param("city") String city);

    @Query("select p from Person p where p.age < :age")
    List<Person> findAllByAgeIsLessThan(@Param("age") int age, Sort sort);

    @Query("select p from Person p where p.name = :name and p.surname = :surname")
    Optional<Person> findByNameEqualsAndSurnameEquals(@Param("name") String name, @Param("surname") String surname);
}
