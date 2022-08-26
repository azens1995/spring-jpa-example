package dev.eklak.springjpaexample.repositories;

import dev.eklak.springjpaexample.entities.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class PersonJpaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Person findById(Integer id) {
        return entityManager.find(Person.class, id);
    }
}
