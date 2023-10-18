package edu.example.springmvcdemo.service;

import edu.example.springmvcdemo.dao.CarRepository;
import edu.example.springmvcdemo.model.Car;
import edu.example.springmvcdemo.util.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class CarService {
    private final PersonService personService;
    private final CarRepository carRepository;

    public Car createCar(LocalDate releaseDate, String color, Model model, Long evp, Long personId) {
        var person = personService.getPerson(personId);
        var car = new Car();
        car.setReleaseDate(releaseDate);
        car.setColor(color);
        car.setModel(model);
        car.setEvp(evp);
        car.setPerson(person);
        return carRepository.save(car);
    }
}
