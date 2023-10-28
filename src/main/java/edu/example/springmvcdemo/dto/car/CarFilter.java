package edu.example.springmvcdemo.dto.car;

import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Predicate;
import edu.example.springmvcdemo.dto.PageDto;
import edu.example.springmvcdemo.model.QCarEntity;
import edu.example.springmvcdemo.util.Model;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

@Data
public class CarFilter extends PageDto {
    private String color;
    private String country;
    private String personName;
    private Model model;

    /**
     * создаем предикат для поиска
     */
    public Predicate toPredicate() {
        var carFilter = QCarEntity.carEntity;
        List<Predicate> predicates = new ArrayList<>();

        if (isNotBlank(color)) {
            predicates.add(carFilter.color.eq(color));
        }
        if (isNotBlank(country)) {
            predicates.add(carFilter.showroom.country.eq(country));
        }
        if (isNotBlank(personName)) {
            predicates.add(carFilter.person.name.eq(personName));
        }
        if (nonNull(model)) {
            predicates.add(carFilter.model.eq(model));
        }

        return ExpressionUtils.allOf(predicates);
    }
}
