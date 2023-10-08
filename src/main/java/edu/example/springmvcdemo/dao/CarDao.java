package edu.example.springmvcdemo.dao;

import edu.example.springmvcdemo.model.Car;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CarDao {
    @Value("${first.owner.name}")
    private String firstOwner;
    private final CarProperty carProperty;
    private final List<Car> cars = new ArrayList<>();
    private Long idCounter = 0L;
    public Car save(Car car) {
        var id = ++idCounter;
        car.setId(id);
        car.setFirstOwner(firstOwner);
        car.setLastOwner(carProperty.getLastOwner());
        cars.add(car);
        return findById(id);
    }

    private Car findById(Long id) {
        return cars.stream().filter(car -> car.getId().equals(id)).findFirst().orElse(null);
    }
}
