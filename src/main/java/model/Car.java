package model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number_;
}
