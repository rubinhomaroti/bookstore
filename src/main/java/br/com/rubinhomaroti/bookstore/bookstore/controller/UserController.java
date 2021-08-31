package br.com.rubinhomaroti.bookstore.bookstore.controller;

import br.com.rubinhomaroti.bookstore.bookstore.dto.AuthDTO;
import br.com.rubinhomaroti.bookstore.bookstore.dto.JwtDTO;
import br.com.rubinhomaroti.bookstore.bookstore.dto.UserCreateDTO;
import br.com.rubinhomaroti.bookstore.bookstore.dto.UserDTO;
import br.com.rubinhomaroti.bookstore.bookstore.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("usuarios")
public class UserController {
    private UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO createUser(@RequestBody UserCreateDTO userCreateDTO){
        return userService.create(userCreateDTO);
    }
    @PostMapping("login")
    public JwtDTO login(@RequestBody AuthDTO authDTO){
        return userService.login(authDTO);
    }
}