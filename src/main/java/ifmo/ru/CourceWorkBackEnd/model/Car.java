package ifmo.ru.CourceWorkBackEnd.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String number_;
}
