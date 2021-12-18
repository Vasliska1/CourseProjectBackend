package ifmo.ru.CourceWorkBackEnd.repository;

import ifmo.ru.CourceWorkBackEnd.model.Factory;
import ifmo.ru.CourceWorkBackEnd.model.FactoryProduction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FactoryProductionRepository extends JpaRepository<FactoryProduction, Integer> {

    @Query(value = "select count_ from factory_production where factory_id = :id and antistress_id = :id_antistress ",  nativeQuery = true)
    int getCount(@Param("id") int id, @Param("id_antistress") int antistress);


}
