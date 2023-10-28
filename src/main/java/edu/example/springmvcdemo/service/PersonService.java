package edu.example.springmvcdemo.service;

import edu.example.springmvcdemo.dao.CarRepository;
import edu.example.springmvcdemo.dao.PersonRepository;
import edu.example.springmvcdemo.model.CarEntity;
import edu.example.springmvcdemo.model.PersonEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;
    private final CarRepository carRepository;

    public PersonEntity getPerson(Long id) {
        return personRepository.findById(id).orElseThrow(() -> new RuntimeException("Такой человек не найден"));
    }

    public PersonEntity createPerson(String name, Integer age) {
        var person = new PersonEntity();
        person.setName(name);
        person.setAge(age);
        return personRepository.save(person);
    }

    public List<Long> updatePersonCars(Long personId, List<Long> carIds) {
        var newCars = carIds.stream()
                .map(carId -> carRepository.findById(carId).orElseThrow(() -> new RuntimeException("Машина с таким id не найдена")))
                .collect(Collectors.toSet());
        var person = personRepository.findById(personId).orElseThrow(() -> new RuntimeException("Человек с таким id не найден"));

        // Явный контроль сущностей - руками обновляем связанные сущности, hibernate увидит изменения и подхватит их
        person.getCars().forEach(car -> car.setPerson(null));
        newCars.forEach(car -> car.setPerson(person));
        person.setCars(newCars);

        return personRepository.saveAndFlush(person).getCars().stream().map(CarEntity::getId).toList();
    }

    public void deletePerson(Long id) {
        var person = personRepository.findById(id).orElseThrow(() -> new RuntimeException("Человек с таким id не найден"));

        person.getCars().forEach(car -> car.setPerson(null));   // отвязываем машины, orphanRemoval отвечает за удаление машин из базы
        personRepository.deleteById(id);    // удаляем человека, каскадное удаление отвечает за удаление машин
    }
}
