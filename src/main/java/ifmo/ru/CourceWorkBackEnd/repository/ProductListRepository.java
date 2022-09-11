package ifmo.ru.CourceWorkBackEnd.repository;

import ifmo.ru.CourceWorkBackEnd.model.DeliveryFact;
import ifmo.ru.CourceWorkBackEnd.model.ProductList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductListRepository extends JpaRepository<ProductList, Integer> {

    @Query(value = "select * from product_list where order_id = :id ",  nativeQuery = true)
    List<ProductList> getOrderProduct(@Param("id") int id);
}
