package com.project.covidactivitytracker.controller;

import com.project.covidactivitytracker.dao.PersonRepository;
import com.project.covidactivitytracker.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class InteractionViewController {

    @Autowired
    private PersonRepository personRespository;

    @GetMapping("/{userId}/persons")
    public List<Person> getPersonsOfUser(@PathVariable Integer userId) {
        return personRespository.getAllUserPersons(userId);
    }
}
