package edu.example.springmvcdemo.controller;

import edu.example.springmvcdemo.model.Car;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Tag(name = "car", description = "работа с машиной")
@RequestMapping("/car")
public class CarController {
    private final List<Car> cars = new ArrayList<>();
    private Long idIncrementor = 0L;

    @PostMapping
    @Operation(description = "Создание машины")
    public String create(@RequestBody @Valid Car car) {
        car.setId(++idIncrementor);
        cars.add(car);
        return "car was ceated: ".concat(car.toString());
    }

    @Operation(description = "Получить список машин")
    @GetMapping
    public List<Car> getCars() {
        return cars;
    }
}
