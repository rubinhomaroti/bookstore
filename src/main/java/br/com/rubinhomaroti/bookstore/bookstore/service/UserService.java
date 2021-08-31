package br.com.rubinhomaroti.bookstore.bookstore.service;

import br.com.rubinhomaroti.bookstore.bookstore.dto.AuthDTO;
import br.com.rubinhomaroti.bookstore.bookstore.dto.JwtDTO;
import br.com.rubinhomaroti.bookstore.bookstore.dto.UserCreateDTO;
import br.com.rubinhomaroti.bookstore.bookstore.dto.UserDTO;

public interface UserService {
    UserDTO create(UserCreateDTO userCreateDTO);
    JwtDTO login(AuthDTO authDTO);
}
