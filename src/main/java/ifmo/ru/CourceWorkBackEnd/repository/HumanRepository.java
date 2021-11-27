package ifmo.ru.CourceWorkBackEnd.repository;

import ifmo.ru.CourceWorkBackEnd.model.Clients;
import ifmo.ru.CourceWorkBackEnd.model.Human;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HumanRepository  extends JpaRepository<Human, Integer> {

    void create();
}
