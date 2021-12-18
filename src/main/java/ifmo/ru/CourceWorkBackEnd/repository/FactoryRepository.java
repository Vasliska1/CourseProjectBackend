package ifmo.ru.CourceWorkBackEnd.repository;

import ifmo.ru.CourceWorkBackEnd.model.District;
import ifmo.ru.CourceWorkBackEnd.model.Factory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FactoryRepository extends JpaRepository<Factory, Integer> {

    @Query(value = "select * from factory where district_id = :id ",  nativeQuery = true)
    Factory getFactoryByDistrict(@Param("id") int id);
}
