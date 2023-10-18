package edu.example.springmvcdemo.controller;

import edu.example.springmvcdemo.dto.person.PersonDto;
import edu.example.springmvcdemo.mapper.PersonMapper;
import edu.example.springmvcdemo.model.Person;
import edu.example.springmvcdemo.service.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public PersonDto createPerson(Person request) {
        return personMapper.toPersonDto(
                personService.createPerson(request.getName(), request.getAge())
        );
    }
}
