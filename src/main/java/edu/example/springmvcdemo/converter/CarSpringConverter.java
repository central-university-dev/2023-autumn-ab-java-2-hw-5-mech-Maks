package edu.example.springmvcdemo.converter;

import edu.example.springmvcdemo.dto.car.CreateCarResponseDto;
import edu.example.springmvcdemo.model.Car;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CarSpringConverter implements Converter<Car, CreateCarResponseDto> {
    @Override
    public CreateCarResponseDto convert(Car source) {
        var result = new CreateCarResponseDto();
        result.setId(source.getId());
        result.setDestroyed(source.getDestroyed());
        result.setColor(source.getColor());
        result.setModel(source.getModel());
        return result;
    }
}
