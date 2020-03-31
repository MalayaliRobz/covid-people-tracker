package com.project.covidactivitytracker.dto;

import com.project.covidactivitytracker.model.User;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@ToString
@NoArgsConstructor
public class PersonDTO {
    @NotNull
    private String name;

    private Timestamp timeOfInteraction;

    private String placeOfInteraction;

    private String additionalInfo;

    @NotNull
    private Integer userId;

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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
