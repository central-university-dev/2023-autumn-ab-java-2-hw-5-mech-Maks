package edu.example.springmvcdemo.model;

import edu.example.springmvcdemo.util.Model;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "car_jn")
public class CarEntity {
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private PersonEntity person;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_showroom_id")
    private CarShowroomEntity showroom;

    @Column(name = "created_at")
    private LocalDateTime created;
}
