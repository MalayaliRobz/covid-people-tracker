package com.project.covidactivitytracker.dao;

import com.project.covidactivitytracker.model.Crowd;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrowdRepository extends JpaRepository<Crowd, Integer> {
}
