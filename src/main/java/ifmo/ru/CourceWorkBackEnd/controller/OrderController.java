package ifmo.ru.CourceWorkBackEnd.controller;

import ifmo.ru.CourceWorkBackEnd.DTO.AntistressDTO;
import ifmo.ru.CourceWorkBackEnd.DTO.ListProduct;
import ifmo.ru.CourceWorkBackEnd.DTO.ProductDTO;
import ifmo.ru.CourceWorkBackEnd.model.*;
import ifmo.ru.CourceWorkBackEnd.repository.AntistressRepository;
import ifmo.ru.CourceWorkBackEnd.service.ClientService;
import ifmo.ru.CourceWorkBackEnd.service.auto.OrderService;
import ifmo.ru.CourceWorkBackEnd.service.auto.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.security.Principal;
import java.util.*;

@Controller
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private AntistressRepository antistressRepository;

    @Autowired
    private ClientService clientService;

    @Autowired
    private UserService userService;

    @PostMapping("/orders")
    public ResponseEntity<?> addClient(Principal principal, @RequestBody ListProduct products) {

        Clients client = clientService.getClientByUser(userService.findByLogin(principal.getName()).getId());
        System.out.println(client);
        Factory factory = clientService.getFabric(client);
        List<ProductDTO> listProductResponse = new ArrayList<ProductDTO>();
        ProductDTO productDTO = new ProductDTO();
        boolean ok = true;
        for (ProductDTO product :
                products.getProducts()) {

            Antistress antistress = antistressRepository.findByKind(product.getName());
            System.out.println(antistress);
            System.out.println(factory.getId());
            int countFabric = orderService.checkProductionOnFabric(factory.getId(), antistress);
            if (countFabric < product.getCount()) {
                productDTO.setCount(countFabric);
                productDTO.setName(antistress.getKind());
                listProductResponse.add(productDTO);
                ok = false;
            }
        }
        if (ok) {
            try {
                Order order = orderService.saveOrder(client, factory);
                for (ProductDTO product : products.getProducts()) {
                    Antistress antistress = antistressRepository.findByKind(product.getName());
                    orderService.saveProductList(antistress, order, product.getCount());
                }
            } catch (Exception e) {
                return new ResponseEntity<>("Some problems on the server", HttpStatus.BAD_REQUEST);
            }
            return ResponseEntity.ok("Ok");
        } else {
            return new ResponseEntity<>(listProductResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/bestPopit")
    public ResponseEntity<?> getBestPopit(Principal principal) {

        Clients client = clientService.getClientByUser(userService.findByLogin(principal.getName()).getId());
        int best = client.getLocation().getDistrict().getCity().getStress().getId();
        return ResponseEntity.ok(best);

    }
}

