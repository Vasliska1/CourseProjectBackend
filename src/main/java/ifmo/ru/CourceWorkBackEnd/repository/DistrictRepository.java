package ifmo.ru.CourceWorkBackEnd.repository;

import ifmo.ru.CourceWorkBackEnd.model.Clients;
import ifmo.ru.CourceWorkBackEnd.model.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DistrictRepository  extends JpaRepository<District, Integer> {

    @Query("select * from district where city_id = :id order by name")
    List<District> getNamebyCity(@Param("id") int city);

    District findById(int id);
}
