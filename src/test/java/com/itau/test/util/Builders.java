package com.itau.test.util;

import com.itau.test.dto.UserRequestDTO;
import com.itau.test.dto.UserResponseDTO;
import com.itau.test.model.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class Builders {

    public static UserRequestDTO createUserRequestDTO() {
        return UserRequestDTO.builder()
                .address("Rua dos campos Silvestres, 188, Centro, New York")
                .email("teste@gmail.com")
                .name("Teste")
                .birthday(LocalDate.parse("1989-09-26"))
                .skills(List.of("Teste 1", "Teste 2"))
                .build();
    }

    public static UserResponseDTO getUserResponseDTO() {
        return UserResponseDTO.builder()
                .id(1L)
                .address("Rua dos campos Silvestres, 188, Centro, New York")
                .email("teste@gmail.com")
                .name("Teste")
                .birthday(LocalDate.parse("1989-09-26"))
                .skills(List.of("Teste 1", "Teste 2"))
                .build();
    }

    public static User getUser() {
        return User.builder()
                .address("Rua dos campos Silvestres, 188, Centro, New York")
                .email("teste@gmail.com")
                .name("Teste")
                .birthday(LocalDate.parse("1989-09-26"))
                .skills(List.of("Teste 1", "Teste 2"))
                .build();
    }

    public static Optional<User> getOptionalUser() {
        return Optional.of(User.builder()
                .address("Rua dos campos Silvestres, 188, Centro, New York")
                .id(1L)
                .email("teste@gmail.com")
                .name("Teste")
                .birthday(LocalDate.parse("1989-09-26"))
                .skills(List.of("Teste 1", "Teste 2"))
                .build());
    }

    public static List<UserResponseDTO> getAllUsersResponseDTO() {
        return List.of(getUserResponseDTO(), getUserResponseDTO());
    }

    public static List<User> getAllUsers() {
        return List.of(getUser(), getUser());
    }
}
