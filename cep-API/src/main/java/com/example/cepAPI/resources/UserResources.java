package com.example.cepAPI.resources;

import com.example.cepAPI.model.User;
import com.example.cepAPI.repository.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/api")
@Api(value="API REST User")
public class UserResources {

    @Autowired
    UserRepository userRepository;

    @ApiOperation(value="Retorna uma lista de usuarios")
    @GetMapping("/users")
    public List<User> listUsers() {
        return userRepository.findAll();

    }

    @ApiOperation(value="Retorna um usuario unico")
    @GetMapping("/user/{cep}")
    public User listUserforCep(@PathVariable(value="cep") String cep) {
        return userRepository.findByCep(cep);

    }
    @ApiOperation(value="Salva um usuario unico")
    @PostMapping("/user")
    public User saveUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @ApiOperation(value="Deleta um usuario unico")
    @DeleteMapping("/user")
    public void deleteUser(@RequestBody User user) {
        userRepository.delete(user);
    }

    @ApiOperation(value="Atualiza um usuario unico")
    @PutMapping("/user")
    public User updateUser(@RequestBody User user) {
        return userRepository.save(user);
    }
}
