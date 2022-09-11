package ifmo.ru.CourceWorkBackEnd.controller;

import ifmo.ru.CourceWorkBackEnd.DTO.DeliveryDTO;
import ifmo.ru.CourceWorkBackEnd.DTO.InfoDeliveryDTO;
import ifmo.ru.CourceWorkBackEnd.DTO.ProductDTO;
import ifmo.ru.CourceWorkBackEnd.model.*;
import ifmo.ru.CourceWorkBackEnd.service.DeliveryService;
import ifmo.ru.CourceWorkBackEnd.service.auto.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class DeliveryController {

    @Autowired
    UserService userService;
    @Autowired
    private DeliveryService deliveryService;

    @GetMapping("/delivery/info")
    public ResponseEntity<?> getInfo(Principal principal) {

        DeliveryMan deliveryMan = deliveryService.getDeliveryManByUser(userService.findByLogin(principal.getName()).getId());

        InfoDeliveryDTO infoDeliveryDTO = new InfoDeliveryDTO(deliveryMan.getHuman().getName(),
                deliveryMan.getHuman().getSurname(), deliveryMan.getCar().getNumber_());
        System.out.println(infoDeliveryDTO);
        return new ResponseEntity<>(infoDeliveryDTO, HttpStatus.OK);

    }


    @GetMapping("/delivery/curr")
    public ResponseEntity<?> getCurrDeliv(Principal principal) {
        User user = userService.findByLogin(principal.getName());
        if (!user.getRoleEntity().getName().equals("ROLE_DELIVERY")) {
            return new ResponseEntity<>("Problem", HttpStatus.FORBIDDEN);
        }
        System.out.println((userService.findByLogin(principal.getName()).getId()));
        DeliveryMan deliveryMan = deliveryService.getDeliveryManByUser(userService.findByLogin(principal.getName()).getId());
        System.out.println(deliveryMan);
        List<DeliveryFact> deliveryFactList = deliveryService.getCurrDeliv(deliveryMan.getId());
        List<DeliveryDTO> deliveryDTOList = new ArrayList<DeliveryDTO>();
        for (DeliveryFact deliveryFact :
                deliveryFactList) {
            Order order = deliveryFact.getOrder();
            List<ProductList> productLists = deliveryService.getProductByOrder(order.getId());
            for (ProductList product : productLists) {
                DeliveryDTO deliveryDTO = new DeliveryDTO(product.getAntistress().getKind(),
                        product.getCount_(), order.getClients().getLocation().getAddress(), deliveryFact.getId());
                deliveryDTOList.add(deliveryDTO);
            }
        }
        return new ResponseEntity<>(deliveryDTOList, HttpStatus.OK);
    }

    @GetMapping("/delivery/done")
    public ResponseEntity<?> getDoneDeliv(Principal principal) {
        User user = userService.findByLogin(principal.getName());
        if (!user.getRoleEntity().getName().equals("ROLE_DELIVERY")) {
            return new ResponseEntity<>("Problem", HttpStatus.FORBIDDEN);
        }
        DeliveryMan deliveryMan = deliveryService.getDeliveryManByUser(userService.findByLogin(principal.getName()).getId());
        List<DeliveryFact> deliveryFactList = deliveryService.getDoneDeliv(deliveryMan.getId());
        List<DeliveryDTO> deliveryDTOList = new ArrayList<DeliveryDTO>();
        for (DeliveryFact deliveryFact :
                deliveryFactList) {
            Order order = deliveryFact.getOrder();
            List<ProductList> productLists = deliveryService.getProductByOrder(order.getId());
            for (ProductList product : productLists) {
                DeliveryDTO deliveryDTO = new DeliveryDTO(product.getAntistress().getKind(),
                        product.getCount_(), order.getClients().getLocation().getAddress(), deliveryFact.getId());
                deliveryDTOList.add(deliveryDTO);
            }
        }
        return new ResponseEntity<>(deliveryDTOList, HttpStatus.OK);
    }

    @PostMapping("/delivery/done")
    public ResponseEntity<?> doneDeliv(Principal principal, @RequestParam("id") int id) {
        deliveryService.changeFactDelivery(id);
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }
}
