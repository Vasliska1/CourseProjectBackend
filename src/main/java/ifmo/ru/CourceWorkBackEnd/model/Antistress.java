package ifmo.ru.CourceWorkBackEnd.model;


import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "antistress")
public class Antistress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String kind;
}
