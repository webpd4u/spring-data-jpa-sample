package com.example.springdatajpasample.onetomany.uni;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
@Profile("OneToMany")
public interface PersonRepository extends JpaRepository<Person, Long> {
}
