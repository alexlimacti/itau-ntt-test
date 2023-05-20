package com.itau.test.service;

import com.itau.test.mapper.UserMapper;
import com.itau.test.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static com.itau.test.util.Builders.createUserRequestDTO;
import static com.itau.test.util.Builders.getAllUsers;
import static com.itau.test.util.Builders.getAllUsersResponseDTO;
import static com.itau.test.util.Builders.getOptionalUser;
import static com.itau.test.util.Builders.getUser;
import static com.itau.test.util.Builders.getUserResponseDTO;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class UserServiceTest {

    private static final String EMAIL = "teste@gmail.com";

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this); //without this you will get NPE
    }


    @Test
    public void createUserTest() {
        var userRequestDTO = createUserRequestDTO();
        var userResponseDTO = getUserResponseDTO();
        var user = getUser();
        when(userRepository.save(user)).thenReturn(user);
        when(userMapper.getUser(userRequestDTO)).thenReturn(user);
        when(userService.save(userRequestDTO)).thenReturn(userResponseDTO);
        var userSaved = userService.save(userRequestDTO);
        Assertions.assertNotNull(userSaved);
        verify(userRepository,times(2)).save(user);
    }

    @Test
    public void getUserByEmailTest() {
        var userResponseDTO = getUserResponseDTO();
        var optionalUser = getOptionalUser();
        var user = getUser();
        when(userRepository.findByEmail(EMAIL)).thenReturn(optionalUser);
        when(userMapper.getUserResponseDTO(user)).thenReturn(userResponseDTO);
        when(userService.findByEmail(EMAIL)).thenReturn(userResponseDTO);
        var userFinded = userService.findByEmail(EMAIL);
        Assertions.assertNotNull(userFinded);
        verify(userRepository,times(2)).findByEmail(EMAIL);
    }

    @Test
    public void getAllUsersTest() {
        var userResponseDTOs = getAllUsersResponseDTO();
        var users = getAllUsers();
        when(userRepository.findAll()).thenReturn(users);
        when(userMapper.getListUserResponseDTO(users)).thenReturn(userResponseDTOs);
        when(userService.findAll()).thenReturn(userResponseDTOs);
        var userFinded = userService.findAll();
        Assertions.assertNotNull(userFinded);
        verify(userRepository,times(2)).findAll();
    }

}
