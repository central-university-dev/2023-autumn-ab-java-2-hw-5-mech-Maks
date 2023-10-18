package edu.example.springmvcdemo.validation.validators;

import edu.example.springmvcdemo.dto.car.CreateCarRequestDto;
import edu.example.springmvcdemo.util.Model;
import edu.example.springmvcdemo.validation.constraints.CarConstraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class CarValidator implements ConstraintValidator<CarConstraint, CreateCarRequestDto> {
    private static final String MSG_NOT_EXISTING_MODEL = MessageFormat.format("Указанной модели не существует, допустимые модели: {0}",
            Arrays.toString(Model.values()));
    private static final String MSG_BAD_RELEASE_DATE = "Неправильный формат даты, нужный формат: dd-MM-yyyy";

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    @Override
    public boolean isValid(CreateCarRequestDto request, ConstraintValidatorContext constraintValidatorContext) {
        try {
            var model = Model.valueOf(request.getCarModel());
        } catch (Exception e) {
            constraintValidatorContext.buildConstraintViolationWithTemplate(MSG_NOT_EXISTING_MODEL).addConstraintViolation();
            return false;
        }

        try {
            var releaseDate = LocalDate.parse(request.getReleaseDate(), formatter);
        } catch (Exception e) {
            constraintValidatorContext.buildConstraintViolationWithTemplate(MSG_BAD_RELEASE_DATE).addConstraintViolation();
            return false;
        }

        return true;
    }
}
