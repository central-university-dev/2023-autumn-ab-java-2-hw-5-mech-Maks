package edu.example.springmvcdemo.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class PageDto {
    /**
     * текущая страница
     */
    @Min(value = 0, message = "'pageNumber' должно быть больше или равно 0")
    protected int pageNumber = 0;

    /**
     * максимальное кол-во элементов на странице
     */
    @Min(value = 1, message = "'pageSize' должно быть больше или равно 1")
    @Max(value = 5000, message = "'pageSize' должно быть меньше или равно 5000")
    protected int pageSize = 50;
}
