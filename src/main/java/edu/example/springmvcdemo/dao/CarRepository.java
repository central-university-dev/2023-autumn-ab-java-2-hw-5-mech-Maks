package edu.example.springmvcdemo.dao;

import edu.example.springmvcdemo.model.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface CarRepository extends JpaRepository<CarEntity, Long>, QuerydslPredicateExecutor<CarEntity> {
}
