package edu.example.springmvcdemo.validation.validators;

import edu.example.springmvcdemo.model.Car;
import edu.example.springmvcdemo.util.Model;
import edu.example.springmvcdemo.validation.constraints.CarConstraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CarValidator implements ConstraintValidator<CarConstraint, Car> {
    @Override
    public boolean isValid(Car car, ConstraintValidatorContext constraintValidatorContext) {
        try {
            var model = Model.valueOf(car.getModel());
        } catch (Exception e) {
            constraintValidatorContext.buildConstraintViolationWithTemplate("Указанной модели не существует").addConstraintViolation();
            return false;
        }

        return true;
    }
}
