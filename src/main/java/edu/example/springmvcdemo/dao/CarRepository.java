package edu.example.springmvcdemo.dao;

import edu.example.springmvcdemo.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
