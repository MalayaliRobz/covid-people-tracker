package com.project.covidactivitytracker.dao;

import com.project.covidactivitytracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
