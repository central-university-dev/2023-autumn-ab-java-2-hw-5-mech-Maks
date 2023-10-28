package edu.example.springmvcdemo.controller;

import edu.example.springmvcdemo.dto.PageResponse;
import edu.example.springmvcdemo.dto.car.CarFilter;
import edu.example.springmvcdemo.dto.car.CarResponseDto;
import edu.example.springmvcdemo.dto.car.CreateCarRequestDto;
import edu.example.springmvcdemo.mapper.CarMapper;
import edu.example.springmvcdemo.service.CarService;
import edu.example.springmvcdemo.util.Model;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "car", description = "работа с машиной")
@RequestMapping("/car")
public class CarController {
    private final CarService carService;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @PostMapping
    @Operation(description = "Создание машины")
    public CarResponseDto create(@RequestBody @Valid CreateCarRequestDto request) {
        var car = carService.createCar(
                LocalDate.parse(request.getReleaseDate(), formatter),
                request.getColor(),
                Model.valueOf(request.getCarModel()),
                request.getEvp(),
                request.getPersonId()
        );

        return CarMapper.INSTANCE.toCarResponseDto(car);
    }

    @GetMapping("/list")
    @Operation(description = "Поиск машин по фильтру")
    public PageResponse<CarResponseDto> findCars(@Valid CarFilter filter) {
        var result = carService.findCars(filter.getPageNumber(), filter.getPageSize(), filter.toPredicate());

        var response = new PageResponse();
        response.setPageSize(result.getSize());
        response.setPageNumber(result.getNumber());
        response.setTotalPages(result.getTotalPages());
        response.setTotalSize(result.getTotalElements());
        response.setContent(result.getContent().stream().map(CarMapper.INSTANCE::toCarResponseDto).toList());

        return response;
    }
}
