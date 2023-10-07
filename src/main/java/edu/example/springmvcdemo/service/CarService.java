package edu.example.springmvcdemo.service;

import edu.example.springmvcdemo.dao.CarDao;
import edu.example.springmvcdemo.model.Car;
import edu.example.springmvcdemo.util.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarDao carDao;
    public Car createCar(LocalDate created, LocalDate destroyed, String color, Model model) {
        var car = new Car();
        car.setCreated(created);
        car.setDestroyed(destroyed);
        car.setColor(color);
        car.setModel(model);
        return carDao.save(car);
    }
}
