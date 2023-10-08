package edu.example.springmvcdemo.model;

import edu.example.springmvcdemo.util.Model;
import lombok.Data;

import java.time.LocalDate;

@Data
public class Car {
    private Long id;
    private LocalDate created;
    private LocalDate destroyed;
    private String color;
    private Model model;
    private String firstOwner;
    private String lastOwner;
}
