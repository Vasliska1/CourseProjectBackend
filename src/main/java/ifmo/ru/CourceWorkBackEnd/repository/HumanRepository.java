package ifmo.ru.CourceWorkBackEnd.repository;

import ifmo.ru.CourceWorkBackEnd.model.Clients;
import ifmo.ru.CourceWorkBackEnd.model.Human;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface HumanRepository  extends JpaRepository<Human, Integer> {

    @Query(value = "select * from human where phone_number = :phone limit 1",  nativeQuery = true)
    Human findbyPhone(@Param("phone")String phone_number);

}
