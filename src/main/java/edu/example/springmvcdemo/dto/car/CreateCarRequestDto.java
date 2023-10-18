package edu.example.springmvcdemo.dto.car;


import edu.example.springmvcdemo.validation.constraints.CarConstraint;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@CarConstraint
public class CreateCarRequestDto {
    private String releaseDate;

    @Size(max = 50, message = "Длина названия цвета не должна превышать 50 символов")
    private String color;

    private String carModel;

    /**
     * Электронный паспорт транспортного средства
     */
    @Min(value = 1, message = "ЭПТС должен быть положительным числом")
    private Long evp;

    /**
     * Текущий владелец ТС
     */
    @NotNull
    private Long personId;
}

