package edu.example.springmvcdemo.mapper;

import edu.example.springmvcdemo.dto.car.CreateCarResponseDto;
import edu.example.springmvcdemo.model.Car;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring")
public interface CarMapper {
    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    @Mapping(target = "id", source = "car.id")
    @Mapping(target = "releaseDate", source = "car.releaseDate")
    @Mapping(target = "color", source = "car.color", qualifiedByName = "colorMapper")
    @Mapping(target = "model", source = "car.model")
    @Mapping(target = "evp", source = "car.evp")
    @Mapping(target = "personId", source = "car.person.id")
    CreateCarResponseDto toCreateCarResponseDto(Car car);

    @Named("colorMapper")
    static String colorMapperMethod(String color) {
        return color.toUpperCase();
    }
}
