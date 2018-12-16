package com.example.springdatajpasample.onetomany.bi;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepositoryOneToManyBi extends JpaRepository<PersonOneToManyBi, Long> {
}
