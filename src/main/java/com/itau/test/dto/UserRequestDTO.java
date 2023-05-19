package com.itau.test.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.itau.test.annotations.NotEmptySkills;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.List;
@Getter
@Setter
public class UserRequestDTO {

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9.\\-\\/+=@_ ]*$")
    private String name;

    @Email
    @NotBlank
    private String email;

    @JsonFormat(pattern = "DD-MM-YYYY")
    private LocalDate birthday;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9.\\-\\/+=@_ ]*$")
    private String address;

    @NotEmptySkills
    private List<String> skills;

}
