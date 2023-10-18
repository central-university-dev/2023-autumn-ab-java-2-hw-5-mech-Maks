package edu.example.springmvcdemo.dto.car;

import edu.example.springmvcdemo.util.Model;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateCarResponseDto {
    private Long id;
    private LocalDate releaseDate;
    private String color;
    private Model model;
    private Long evp;
    private Long personId;
}
