package edu.example.springmvcdemo.dao;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("!prod")
@Getter
@Setter
public class CarPropertyImpl implements CarProperty {
    @Value("${last.owner.name}")
    private String lastOwner;
}
