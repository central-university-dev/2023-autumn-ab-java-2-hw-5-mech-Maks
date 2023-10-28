package edu.example.springmvcdemo.dao;

import edu.example.springmvcdemo.model.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
}
