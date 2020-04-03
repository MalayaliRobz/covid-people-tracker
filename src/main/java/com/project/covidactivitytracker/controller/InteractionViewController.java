package com.project.covidactivitytracker.controller;

import com.project.covidactivitytracker.dao.PersonRepository;
import com.project.covidactivitytracker.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/")
public class InteractionViewController {

    @Autowired
    private PersonRepository personRespository;

    @GetMapping("/{userId}/persons")
    public List<Person> getPersonsOfUser(
            @PathVariable Integer userId,
            @RequestParam(name = "date", required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") Date date,
            @RequestParam(name = "endDate", required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") Date endDate
            ) {
        if (date != null) {
            Date nextDay = new Date(date.getTime() + (1000 * 60 * 60 * 24));
            if (endDate != null) {
                nextDay = endDate;
            }

            Timestamp dayPassedTimestamp = new Timestamp(date.getTime());
            Timestamp nextDayTimestamp = new Timestamp(nextDay.getTime());

            return personRespository.getAllUserPersonsWithDate(userId, dayPassedTimestamp, nextDayTimestamp);
        } else {
            List<Person> test =  personRespository.getAllUserPersons(userId);
            return test;
        }
    }
}
