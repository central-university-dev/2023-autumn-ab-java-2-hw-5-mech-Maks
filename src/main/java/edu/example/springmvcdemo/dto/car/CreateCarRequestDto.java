package edu.example.springmvcdemo.dto.car;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import edu.example.springmvcdemo.validation.constraints.CarConstraint;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@CarConstraint
public class CreateCarRequestDto {
    @Pattern(regexp="^\\d{2}-\\d{2}-\\d{4}$", message="Формат даты создания должен быть в виде 'dd-mm-yyyy'")
    private String created;

    @Pattern(regexp="^\\d{2}-\\d{2}-\\d{4}$", message="Формат даты уничтожения должен быть в виде 'dd-mm-yyyy'")
    private String destroyed;

    @Size(max = 50, message = "Длина названия цвета не должна превышать 50 символов")
    private String color;

    @JsonProperty("car_model")
    @JsonAlias({"model", "another_model"})
    private String model;
}

