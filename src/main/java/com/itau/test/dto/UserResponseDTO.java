package com.itau.test.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
public class UserResponseDTO {

    private Long id;
    private String name;
    private String email;
    private LocalDate birthday;
    private String address;
    private List<String> skills;

}
