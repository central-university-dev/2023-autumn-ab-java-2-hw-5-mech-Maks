package edu.example.springmvcdemo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "car_showroom_ref")
public class CarShowroomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car_showroom_ref_seq")
    @SequenceGenerator(name = "car_showroom_ref_seq", sequenceName = "car_showroom_ref_seq", allocationSize = 1)
    private Long id;

    @Column(name = "address")
    private String address;

    @Column(name = "country")
    private String country;

    @Column(name = "name")
    private String name;
}
