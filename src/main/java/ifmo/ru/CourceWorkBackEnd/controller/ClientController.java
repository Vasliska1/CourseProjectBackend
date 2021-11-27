package ifmo.ru.CourceWorkBackEnd.controller;


import ifmo.ru.CourceWorkBackEnd.DTO.ClientDTO;
import ifmo.ru.CourceWorkBackEnd.DTO.UserDTO;
import ifmo.ru.CourceWorkBackEnd.service.ClientService;
import ifmo.ru.CourceWorkBackEnd.service.auto.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@CrossOrigin
public class ClientController {

    @Autowired
    private ClientService clientService;


    @PostMapping("/client")
    public String addClient(@RequestBody @Valid ClientDTO client) {


    }
}