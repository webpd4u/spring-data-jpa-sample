package com.example.springdatajpasample.manytomany.uni;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepositoryManyToManyUni extends JpaRepository<PersonManyToManyUni, Long> {
}
