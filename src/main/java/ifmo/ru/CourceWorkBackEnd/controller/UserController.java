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
        if (userService.findByLogin(userDTO.getLogin()) != null) {
            return new ResponseEntity<>("Такой пользователь уже есть!", HttpStatus.CONFLICT);
        }
        User u = new User();
        System.out.println(u);
        u.setPassword(userDTO.getPassword());
        u.setLogin(userDTO.getLogin());
        userService.saveUser(u, userDTO.getRole());
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> auth(@RequestBody UserDTO request) {
        try {
            User userEntity = userService.  findByLoginAndPassword(request.getLogin(), request.getPassword());
            String token = jwtProvider.generateToken(userEntity.getLogin());
            return new ResponseEntity<>(token, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Неверный логин или пароль", HttpStatus.UNAUTHORIZED);
        }
    }
}
