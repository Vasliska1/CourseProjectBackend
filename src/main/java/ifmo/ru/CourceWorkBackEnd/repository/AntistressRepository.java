package ifmo.ru.CourceWorkBackEnd.repository;

import ifmo.ru.CourceWorkBackEnd.model.Antistress;
import ifmo.ru.CourceWorkBackEnd.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AntistressRepository extends JpaRepository<Antistress, Integer> {

    Antistress findByKind(String name);
}
