package ifmo.ru.CourceWorkBackEnd.service;

import ifmo.ru.CourceWorkBackEnd.model.*;
import ifmo.ru.CourceWorkBackEnd.repository.ClientsRepository;
import ifmo.ru.CourceWorkBackEnd.repository.FactoryRepository;
import ifmo.ru.CourceWorkBackEnd.repository.HumanRepository;
import ifmo.ru.CourceWorkBackEnd.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientsRepository clientsRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private FactoryRepository factoryRepository;

    public void saveClients(Clients clients) {
        clientsRepository.save(clients);
    }

    public Factory getFabric(Clients client) {

        District district = client.getLocation().getDistrict();
        Factory factory = factoryRepository.getFactoryByDistrict(district.getId());
        return factory;
    }

    public Clients getClientByUser(int id) {
        return clientsRepository.getClientbyUser(id);
    }


}
