package ifmo.ru.CourceWorkBackEnd.controller;


import ifmo.ru.CourceWorkBackEnd.DTO.ClientDTO;
import ifmo.ru.CourceWorkBackEnd.DTO.UserDTO;
import ifmo.ru.CourceWorkBackEnd.model.*;
import ifmo.ru.CourceWorkBackEnd.repository.LocationRepository;
import ifmo.ru.CourceWorkBackEnd.repository.SubscriptionRepository;
import ifmo.ru.CourceWorkBackEnd.service.ClientService;
import ifmo.ru.CourceWorkBackEnd.service.HumanService;
import ifmo.ru.CourceWorkBackEnd.service.LocationService;
import ifmo.ru.CourceWorkBackEnd.service.auto.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@CrossOrigin
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private HumanService humanService;

    @Autowired
    private UserService userService;

    @Autowired
    private SubscriptionRepository subscription;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private LocationService locationService;

    @PostMapping("/client")
    public ResponseEntity<String> addClient(@RequestBody Human human, int idDistr, String addres, Principal principal) {
        humanService.saveHuman(human);
        User n_user = userService.findByLogin(principal.getName());
        District district = locationService.getDistrictById(idDistr);
        Location location = new Location(district, addres);
        locationRepository.save(location);
        Clients clients = new Clients(human, location, subscription.getOne(1), n_user);
        clientService.saveClients(clients);
        return new ResponseEntity<>("Save", HttpStatus.CREATED);
    }
}