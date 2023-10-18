package edu.example.springmvcdemo.mapper;

import edu.example.springmvcdemo.dto.person.PersonDto;
import edu.example.springmvcdemo.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PersonMapper {
//    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    PersonDto toPersonDto(Person source);
}
