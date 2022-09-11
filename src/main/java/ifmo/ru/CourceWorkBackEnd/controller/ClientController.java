package ifmo.ru.CourceWorkBackEnd.controller;


import ifmo.ru.CourceWorkBackEnd.DTO.InfoHumanDTO;
import ifmo.ru.CourceWorkBackEnd.model.*;
import ifmo.ru.CourceWorkBackEnd.repository.LocationRepository;
import ifmo.ru.CourceWorkBackEnd.repository.SubscriptionRepository;
import ifmo.ru.CourceWorkBackEnd.service.ClientService;
import ifmo.ru.CourceWorkBackEnd.service.DeliveryService;
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
    private DeliveryService deliveryService;
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
        try {
            if (humanService.getByNumber(human.getPhone_number()) != null) {
                return new ResponseEntity<>("Такой номер телефона уже существует", HttpStatus.CONFLICT);
            }
            humanService.saveHuman(human);
            System.out.println(principal.getName());
            User n_user = userService.findByLogin(principal.getName());
            District district = locationService.getDistrictByNameAndCity(city, distr);
            Location location = new Location(district, address);
            locationRepository.save(location);
            if (n_user.getRoleEntity().getName().equals("ROLE_USER")) {
                Clients clients = new Clients(human, location, subscription.getOne(1), n_user);
                clientService.saveClients(clients);
            } else {
                DeliveryMan deliveryMan = new DeliveryMan(human, district, null, n_user);
                deliveryService.saveDeliveryMan(deliveryMan);
            }
            return new ResponseEntity<>("Save", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Problems", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/info")
    public ResponseEntity<?> getInfo(Principal principal) {
        try {
            Clients client = clientService.getClientByUser(userService.findByLogin(principal.getName()).getId());
            Human human = client.getHuman();
            String address = client.getLocation().getAddress();
            String nameDistr = client.getLocation().getDistrict().getName();
            String city = client.getLocation().getDistrict().getCity().getName();
            InfoHumanDTO infoHumanDTO = new InfoHumanDTO(human.getName(), human.getSurname(), address, human.getPhone_number(), city, nameDistr);
            return new ResponseEntity<>(infoHumanDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Problems", HttpStatus.BAD_REQUEST);
        }

    }
}