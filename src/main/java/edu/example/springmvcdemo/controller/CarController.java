package edu.example.springmvcdemo.controller;

import edu.example.springmvcdemo.dto.car.CreateCarRequestDto;
import edu.example.springmvcdemo.dto.car.CreateCarResponseDto;
import edu.example.springmvcdemo.mapper.CarMapper;
import edu.example.springmvcdemo.service.CarService;
import edu.example.springmvcdemo.util.Model;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@RequiredArgsConstructor
@Tag(name = "car", description = "работа с машиной")
@RequestMapping("/car")
public class CarController {
    private final CarService carService;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @PostMapping
    @Operation(description = "Создание машины")
    public CreateCarResponseDto create(@RequestBody @Valid CreateCarRequestDto request) {
        var car = carService.createCar(
                LocalDate.parse(request.getReleaseDate(), formatter),
                request.getColor(),
                Model.valueOf(request.getCarModel()),
                request.getEvp(),
                request.getPersonId()
        );

        return CarMapper.INSTANCE.toCreateCarResponseDto(car);
    }
}
