package edu.example.springmvcdemo.dao;

import edu.example.springmvcdemo.model.Car;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarDao {
    private final List<Car> cars = new ArrayList<>();
    private Long idCounter = 0L;
    public Car save(Car car) {
        var id = ++idCounter;
        car.setId(id);
        cars.add(car);
        return findById(id);
    }

    private Car findById(Long id) {
        return cars.stream().filter(car -> car.getId().equals(id)).findFirst().orElse(null);
    }
}
