package com.project.covidactivitytracker.dto;

import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@ToString
@NoArgsConstructor
public class UserDTO {

    @NotNull
    private String name;

    @NotNull
    private String email;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
