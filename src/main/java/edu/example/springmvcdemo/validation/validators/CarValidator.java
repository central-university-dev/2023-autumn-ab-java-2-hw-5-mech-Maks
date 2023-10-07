package edu.example.springmvcdemo.validation.validators;

import edu.example.springmvcdemo.dto.car.CreateCarRequestDto;
import edu.example.springmvcdemo.util.Model;
import edu.example.springmvcdemo.validation.constraints.CarConstraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CarValidator implements ConstraintValidator<CarConstraint, CreateCarRequestDto> {
    @Override
    public boolean isValid(CreateCarRequestDto request, ConstraintValidatorContext constraintValidatorContext) {
        try {
            var model = Model.valueOf(request.getModel());
        } catch (Exception e) {
            constraintValidatorContext.buildConstraintViolationWithTemplate("Указанной модели не существует").addConstraintViolation();
            return false;
        }

        return true;
    }
}
