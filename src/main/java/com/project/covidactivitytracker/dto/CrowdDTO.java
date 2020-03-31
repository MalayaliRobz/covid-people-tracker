package com.project.covidactivitytracker.dto;

import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@ToString
@NoArgsConstructor
public class CrowdDTO {

    @NotNull
    private String name;

    @NotNull
    private Integer count;

    private Timestamp timeOfInteraction;

    private String placeOfInteraction;

    private String additionalInfo;

    public String getName() {
        return name;
    }

    public Integer getCount() {
        return count;
    }

    public Timestamp getTimeOfInteraction() {
        return timeOfInteraction;
    }

    public String getPlaceOfInteraction() {
        return placeOfInteraction;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public Integer getUserId() {
        return userId;
    }

    @NotNull
    private Integer userId;

}
