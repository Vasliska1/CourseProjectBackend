package ifmo.ru.CourceWorkBackEnd.controller;

import ifmo.ru.CourceWorkBackEnd.DTO.AuthResponse;
import ifmo.ru.CourceWorkBackEnd.DTO.UserDTO;
import ifmo.ru.CourceWorkBackEnd.filter.JwtProvider;
import ifmo.ru.CourceWorkBackEnd.model.User;
import ifmo.ru.CourceWorkBackEnd.service.auto.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private JwtProvider jwtProvider;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody @Valid UserDTO userDTO) {
        User u = new User();
        u.setPassword(userDTO.getPassword());
        u.setLogin(userDTO.getLogin());
        userService.saveUser(u);
        return new ResponseEntity<>("Ok", HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public AuthResponse auth(@RequestBody UserDTO request) {
        User userEntity = userService.findByLoginAndPassword(request.getLogin(), request.getPassword());
        String token = jwtProvider.generateToken(userEntity.getLogin());
        return new AuthResponse(token);
    }
}
