package ifmo.ru.CourceWorkBackEnd.service;

import ifmo.ru.CourceWorkBackEnd.model.Clients;
import ifmo.ru.CourceWorkBackEnd.model.Human;
import ifmo.ru.CourceWorkBackEnd.repository.ClientsRepository;
import ifmo.ru.CourceWorkBackEnd.repository.HumanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientsRepository clientsRepository;

    public void saveClients(Clients clients) {
        clientsRepository.save(clients);
    }
}
