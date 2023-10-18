package edu.example.springmvcdemo.service;

import edu.example.springmvcdemo.dao.PersonRepository;
import edu.example.springmvcdemo.model.Person;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;

    public Person getPerson(Long id) {
        return personRepository.findById(id).orElseThrow(() -> new RuntimeException("Такой человек не найден"));
    }

    public Person createPerson(String name, Integer age) {
        var person = new Person();
        person.setName(name);
        person.setAge(age);
        return personRepository.save(person);
    }
}
