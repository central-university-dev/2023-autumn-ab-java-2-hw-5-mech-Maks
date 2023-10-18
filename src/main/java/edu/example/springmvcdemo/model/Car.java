package edu.example.springmvcdemo.model;

import edu.example.springmvcdemo.util.Model;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "car_jn")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car_jn_seq")
    @SequenceGenerator(name = "car_jn_seq", sequenceName = "car_jn_seq", allocationSize = 1)
    private Long id;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "color")
    private String color;

    @Enumerated(EnumType.STRING)
    @Column(name = "model")
    private Model model;

    /**
     * Электронный паспорт транспортного средства
     */
    @Column(name = "evp")
    private Long evp;

    /**
     * Действующий владелец машины
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id")
    private Person person;
}
