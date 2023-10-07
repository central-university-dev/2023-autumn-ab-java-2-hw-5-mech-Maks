package edu.example.springmvcdemo.controller;

import edu.example.springmvcdemo.converter.CarSpringConverter;
import edu.example.springmvcdemo.dto.car.CreateCarRequestDto;
import edu.example.springmvcdemo.dto.car.CreateCarResponseDto;
import edu.example.springmvcdemo.mapper.CarMapper;
import edu.example.springmvcdemo.service.CarService;
import edu.example.springmvcdemo.util.Model;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@RequiredArgsConstructor
@Tag(name = "car", description = "работа с машиной")
@RequestMapping("/car")
public class CarController {
    private final CarService carService;
    private final CarSpringConverter carSpringConverter;
    private final ConversionService conversionService;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @PostMapping
    @Operation(description = "Создание машины")
    public CreateCarResponseDto create(@RequestBody @Valid CreateCarRequestDto request) {
        var car = carService.createCar(
                LocalDate.parse(request.getCreated(), formatter),
                LocalDate.parse(request.getDestroyed(), formatter),
                request.getColor(),
                Model.valueOf(request.getModel())
        );

//        return conversionService.convert(car, CreateCarResponseDto.class);   // НИКОГДА ТАК НЕ ПИШИТЕ
        return CarMapper.INSTANCE.toCreateCarResponseDto(car);
    }
}
