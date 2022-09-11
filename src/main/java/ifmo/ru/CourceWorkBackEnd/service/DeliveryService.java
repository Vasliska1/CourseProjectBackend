package ifmo.ru.CourceWorkBackEnd.service;

import ifmo.ru.CourceWorkBackEnd.model.Clients;
import ifmo.ru.CourceWorkBackEnd.model.DeliveryFact;
import ifmo.ru.CourceWorkBackEnd.model.DeliveryMan;
import ifmo.ru.CourceWorkBackEnd.model.ProductList;
import ifmo.ru.CourceWorkBackEnd.repository.DeliveryFactRepository;
import ifmo.ru.CourceWorkBackEnd.repository.DeliveryManRepository;
import ifmo.ru.CourceWorkBackEnd.repository.ProductListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryService {

    @Autowired
    private DeliveryFactRepository deliveryFactRepository;
    @Autowired
    private DeliveryManRepository deliveryManRepository;
    @Autowired
    private ProductListRepository productListRepository;


    public DeliveryMan getDeliveryManByUser(int userId) {
        return deliveryManRepository.getDeliverybyUser(userId);
    }

    public List<DeliveryFact> getCurrDeliv(int delivId) {

        return deliveryFactRepository.getCurrDeliv(delivId);

    }

    public List<DeliveryFact> getDoneDeliv(int delivId) {

        return deliveryFactRepository.getDoneDeliv(delivId);
    }

    public List<ProductList> getProductByOrder(int orderId) {

        return productListRepository.getOrderProduct(orderId);
    }

    public void changeFactDelivery(int id) {
        deliveryFactRepository.changeFact(id);
    }

    public void saveDeliveryMan(DeliveryMan deliveryMan) {
        deliveryManRepository.save(deliveryMan);
    }
}
