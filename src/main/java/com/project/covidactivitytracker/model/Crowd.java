package com.project.covidactivitytracker.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
@Table(name = "crowd")
public class Crowd {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "count")
    private Integer count;

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

    public Crowd() {
    }

    public Crowd(String name, Integer count, Timestamp timeOfInteraction, String placeOfInteraction, String additionalInfo, @NotNull User user) {
        this.name = name;
        this.count = count;
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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
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
