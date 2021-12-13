package ifmo.ru.CourceWorkBackEnd.controller;


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
    public ResponseEntity<String> addClient(Principal principal, @RequestBody Human human,
                                            @RequestParam("city") String city,
                                            @RequestParam("district") String distr,
                                            @RequestParam("address") String address) {
        System.out.println(human);
        System.out.println(city);
        System.out.println(distr);
        System.out.println(address);
        if (humanService.getByNumber(human.getPhone_number()) != null) {
            return new ResponseEntity<>("Такой номер телефона уже существует", HttpStatus.CONFLICT);
        }
        humanService.saveHuman(human);
        System.out.println(principal.getName());
        User n_user = userService.findByLogin(principal.getName());
        District district = locationService.getDistrictByNameAndCity(city, distr);
        Location location = new Location(district, address);
        locationRepository.save(location);
        Clients clients = new Clients(human, location, subscription.getOne(1), n_user);
        clientService.saveClients(clients);
        return new ResponseEntity<>("Save", HttpStatus.OK);
    }
}