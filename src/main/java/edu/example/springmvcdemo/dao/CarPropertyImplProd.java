package edu.example.springmvcdemo.dao;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("prod")
@Getter
@Setter
public class CarPropertyImplProd implements CarProperty {
    private String lastOwner = "prod-last-owner";
}
