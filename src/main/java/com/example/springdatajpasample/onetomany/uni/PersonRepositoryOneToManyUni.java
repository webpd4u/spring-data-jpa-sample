package com.example.springdatajpasample.onetomany.uni;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepositoryOneToManyUni extends JpaRepository<PersonOneToManyUni, Long> {
}
