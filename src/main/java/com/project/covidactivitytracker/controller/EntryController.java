package com.project.covidactivitytracker.controller;

import com.project.covidactivitytracker.dao.CrowdRepository;
import com.project.covidactivitytracker.dao.PersonRepository;
import com.project.covidactivitytracker.dao.UserRepository;
import com.project.covidactivitytracker.dto.CrowdDTO;
import com.project.covidactivitytracker.dto.PersonDTO;
import com.project.covidactivitytracker.dto.UserDTO;
import com.project.covidactivitytracker.model.Crowd;
import com.project.covidactivitytracker.model.Person;
import com.project.covidactivitytracker.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping("entity")
public class EntryController {

    @Autowired
    private PersonRepository personRespository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CrowdRepository crowdRepository;

    @PostMapping("/user")
    public User user(@RequestBody UserDTO userDTO) {
        User user = new User(userDTO.getName(), userDTO.getEmail());

        this.userRepository.save(user);
        return user;
    }

    @PostMapping("/person")
    public Person person(@RequestBody PersonDTO personDTO) {
        Integer userId = personDTO.getUserId();
        User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException(userId.toString()));

        Person person = new Person(
                personDTO.getName(),
                personDTO.getTimeOfInteraction(),
                personDTO.getPlaceOfInteraction(),
                personDTO.getAdditionalInfo(),
                user
        );


        personRespository.save(person);
        return person;
    }

    @DeleteMapping("/person/{personId}")
    public ResponseEntity person(
            @PathVariable Integer personId) {

        personRespository.deleteById(personId);

        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @PostMapping("/crowd")
    public Crowd person(@RequestBody CrowdDTO crowdDTO) {
        Integer userId = crowdDTO.getUserId();
        User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException(userId.toString()));

        Crowd crowd = new Crowd(
                crowdDTO.getName(),
                crowdDTO.getCount(),
                crowdDTO.getTimeOfInteraction(),
                crowdDTO.getPlaceOfInteraction(),
                crowdDTO.getAdditionalInfo(),
                user
        );


        crowdRepository.save(crowd);
        return crowd;
    }
}
