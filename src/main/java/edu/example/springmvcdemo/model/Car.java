package edu.example.springmvcdemo.model;

import edu.example.springmvcdemo.validation.constraints.CarConstraint;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@CarConstraint
public class Car {
    private Long id;

    @Min(value = 0, message = "Машина не может стоить меньше 0 рублей")
    @Max(value = 20000, message = "Машина не может стоить дороже 20 000 рублей")
    private Long price;

    @Size(max = 50, message = "слишком длинное имя для цвета")
    private String color;


    private String model;
}
