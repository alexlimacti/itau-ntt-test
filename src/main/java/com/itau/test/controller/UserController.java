package com.itau.test.controller;

import com.itau.test.dto.UserRequestDTO;
import com.itau.test.dto.UserResponseDTO;
import com.itau.test.service.UserService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@OpenAPIDefinition(
        info = @Info(
                title = "Itau Ntt Challenge",
                description = "Endpoint for creating and querying Users",
                version = "1.0",
                contact = @Contact(name = "Alexsandro de Lima Silva",
                        email = "alexsandrolima.dev@gmail.com")
        ))
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(summary = "Get user by email")
    @GetMapping("/{email}")
    public ResponseEntity<UserResponseDTO> getUserByEmail(@PathVariable String email) {
        log.info("UserController.getUserByEmail - Iniciate");
        var user = userService.findByEmail(email);
        log.info("UserController.getUserByEmail - ended");
        return ResponseEntity.ok(user);
    }

    @Operation(summary = "Get all users")
    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        log.info("UserController.findAll() - Iniciate");
        var users = userService.findAll();
        log.info("UserController.findAll() - ended");
        return ResponseEntity.ok(users);
    }

    @Operation(summary = "Create a new user")
    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody UserRequestDTO userRequestDTO) {
        log.info("UserController.createUse() - Iniciate");
        System.out.println(userRequestDTO.getBirthday());
        var user = userService.save(userRequestDTO);
        log.info("UserController.createUse() - ended");
        return ResponseEntity.status(201).body(user);
    }

    @Operation(summary = "Detele user by email")
    @DeleteMapping("/{email}")
    public ResponseEntity<?> deleteUser(@PathVariable String email) {
        log.info("UserController.createUse() - Iniciate");
        userService.deleteByEmail(email);
        log.info("UserController.createUse() - ended");
        return ResponseEntity.noContent().build();
    }

}
