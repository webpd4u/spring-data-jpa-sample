package com.example.springdatajpasample.manytoone.uni;

import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepositoryManyToOneUni extends JpaRepository<PersonManyToOneUni, Long> {
}
