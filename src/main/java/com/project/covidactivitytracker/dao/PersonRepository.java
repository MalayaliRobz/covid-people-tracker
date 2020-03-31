package com.project.covidactivitytracker.dao;

import com.project.covidactivitytracker.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    @Query("SELECT p FROM Person p where p.user.id = ?1")
    List<Person> getAllUserPersons(Integer user_id);
}
