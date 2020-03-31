package com.project.covidactivitytracker.model;

import com.project.covidactivitytracker.dto.PersonDTO;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Optional;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "time_of_interaction")
    private Timestamp timeOfInteraction;

    @Column(name = "place_of_interaction")
    private String placeOfInteraction;

    @Column(name = "additional_info")
    private String additionalInfo;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Person() {
    }

    public Person(String name, Timestamp timeOfInteraction, String placeOfInteraction, String additionalInfo, User user) {
        this.name = name;
        this.timeOfInteraction = timeOfInteraction;
        this.placeOfInteraction = placeOfInteraction;
        this.additionalInfo = additionalInfo;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getTimeOfInteraction() {
        return timeOfInteraction;
    }

    public void setTimeOfInteraction(Timestamp timeOfInteraction) {
        this.timeOfInteraction = timeOfInteraction;
    }

    public String getPlaceOfInteraction() {
        return placeOfInteraction;
    }

    public void setPlaceOfInteraction(String placeOfInteraction) {
        this.placeOfInteraction = placeOfInteraction;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
