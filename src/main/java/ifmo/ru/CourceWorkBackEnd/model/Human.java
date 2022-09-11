package ifmo.ru.CourceWorkBackEnd.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "human")
public class Human {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String surname;

    private String phone_number;
}
