package edu.example.springmvcdemo.controller;

import edu.example.springmvcdemo.dto.car.CarResponseDto;
import edu.example.springmvcdemo.dto.person.PersonDto;
import edu.example.springmvcdemo.dto.person.UpdatePersonDto;
import edu.example.springmvcdemo.mapper.PersonMapper;
import edu.example.springmvcdemo.service.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
@Tag(name = "person", description = "работа с человеком")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;
    private final PersonMapper personMapper;

    @GetMapping
    @Operation(description = "Найти человека")
    public PersonDto getPerson(Long id) {
        var person = personService.getPerson(id);
        return personMapper.toPersonDto(person);
    }

    @PostMapping
    @Operation(description = "Создать человека")
    public PersonDto createPerson(PersonDto request) {
        return personMapper.toPersonDto(
                personService.createPerson(request.getName(), request.getAge())
        );
    }

    @PostMapping("/update/{id}")
    @Operation(description = "Обновление машин человека")
    public List<Long> updatePersonCars(@PathVariable("id") Long id, @RequestBody @Valid UpdatePersonDto request) {
        return personService.updatePersonCars(id, request.getCarIds());
    }

    @DeleteMapping("/{id}")
    @Operation(description = "Удалить человека")
    public void deletePerson(@PathVariable("id") Long id) {
        personService.deletePerson(id);
    }
}
