package edu.example.springmvcdemo.dto.car;

import edu.example.springmvcdemo.util.Model;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateCarResponseDto {
    private Long id;
    private LocalDate destroyed;
    private String color;
    private Model model;
    private String firstOwner;
    private String lastOwner;
}
