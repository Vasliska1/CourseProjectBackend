package ifmo.ru.CourceWorkBackEnd.service.auto;

import ifmo.ru.CourceWorkBackEnd.DTO.AntistressDTO;
import ifmo.ru.CourceWorkBackEnd.model.*;
import ifmo.ru.CourceWorkBackEnd.repository.FactoryProductionRepository;
import ifmo.ru.CourceWorkBackEnd.repository.OrderRepository;
import ifmo.ru.CourceWorkBackEnd.repository.ProductListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Service
public class OrderService {

    @Autowired
    private FactoryProductionRepository factoryProductionRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductListRepository productListRepository;

    public int checkProductionOnFabric(int factory, Antistress antistress) {

        return factoryProductionRepository.getCount(factory, antistress.getId());
    }

    public Order saveOrder(Clients client, Factory factory){
        int priority = client.getSubscription().getId() +1;
        Order order = new Order(client, LocalDate.now(),factory,priority);
        return orderRepository.save(order);

    }

    public void saveProductList(Antistress antistress, Order order, int count){
        ProductList productList = new ProductList(order, antistress, count);
        productListRepository.save(productList);
    }

}
