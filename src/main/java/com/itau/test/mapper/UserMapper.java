package com.itau.test.mapper;

import com.itau.test.dto.UserRequestDTO;
import com.itau.test.dto.UserResponseDTO;
import com.itau.test.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {

    @Autowired
    private ModelMapper modelMapper;

    public User getUser(UserRequestDTO userRequestDTO) {
        return modelMapper.map(userRequestDTO, User.class);
    }

    public UserResponseDTO getUserResponseDTO(User user) {
        return modelMapper.map(user, UserResponseDTO.class);
    }

    public List<UserResponseDTO> getListUserResponseDTO(List<User> userList) {
        var listUserResponseDTO = new ArrayList<UserResponseDTO>();
        userList.forEach(user -> {
            listUserResponseDTO.add(getUserResponseDTO(user));
        });
        return listUserResponseDTO;
    }
}
