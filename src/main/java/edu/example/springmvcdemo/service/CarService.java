package edu.example.springmvcdemo.service;

import com.querydsl.core.types.Predicate;
import edu.example.springmvcdemo.dao.CarRepository;
import edu.example.springmvcdemo.dao.PersonRepository;
import edu.example.springmvcdemo.model.CarEntity;
import edu.example.springmvcdemo.model.PersonEntity;
import edu.example.springmvcdemo.util.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.springframework.transaction.annotation.Propagation.MANDATORY;

@Service
@RequiredArgsConstructor
public class CarService {
    private final PersonRepository personRepository;
    private final CarRepository carRepository;

    public CarEntity createCar(LocalDate releaseDate, String color, Model model, Long evp, Long personId) {
        var person = personRepository.findById(personId).orElseThrow(() -> new RuntimeException("Такой человек не найден"));
        var car = new CarEntity();
        car.setReleaseDate(releaseDate);
        car.setColor(color);
        car.setModel(model);
        car.setEvp(evp);
        car.setPerson(person);
        return carRepository.save(car);
    }

    public Page<CarEntity> findCars(int pageNumber, int pageSize, Predicate predicate) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(
                Sort.Order.desc("created")
        ));

        return carRepository.findAll(predicate, pageable);
    }
}
