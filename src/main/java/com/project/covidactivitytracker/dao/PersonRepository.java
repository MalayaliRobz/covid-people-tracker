package com.project.covidactivitytracker.dao;

import com.project.covidactivitytracker.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    @Query("SELECT p FROM Person p where p.user.id = ?1")
    List<Person> getAllUserPersons(Integer user_id);

    @Query("SELECT p FROM Person p WHERE p.user.id = ?1 AND (p.timeOfInteraction >= ?2 AND p.timeOfInteraction < ?3)")
    List<Person> getAllUserPersonsWithDate(Integer userId, Timestamp startDateTime, Timestamp endDateTime);
}
