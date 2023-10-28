package edu.example.springmvcdemo.dto.person;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class UpdatePersonDto {
    @NotNull(message = "Необходимо указать список машин, принадлежащих человеку")
    List<Long> carIds;
}
