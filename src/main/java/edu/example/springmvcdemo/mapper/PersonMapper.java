package edu.example.springmvcdemo.mapper;

import edu.example.springmvcdemo.dto.person.PersonDto;
import edu.example.springmvcdemo.model.PersonEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    PersonDto toPersonDto(PersonEntity source);
}
