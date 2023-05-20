package com.itau.test.service;

import com.itau.test.dto.UserRequestDTO;
import com.itau.test.dto.UserResponseDTO;
import com.itau.test.exception.AgeException;
import com.itau.test.exception.EmailException;
import com.itau.test.exception.UserException;
import com.itau.test.mapper.UserMapper;
import com.itau.test.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public UserResponseDTO findByEmail(String email) {
        var user = userRepository.findByEmail(email).orElseThrow(() -> new UserException("User with email " + email +
                " not found."));
        return userMapper.getUserResponseDTO(user);
    }

    public List<UserResponseDTO> findAll() {
        return userMapper.getListUserResponseDTO(userRepository.findAll());
    }

    public UserResponseDTO save(UserRequestDTO userRequestDTO) {
        if(!userRepository.findByEmail(userRequestDTO.getEmail()).isEmpty()) throw new UserException("User already exist");
        var user = userMapper.getUser(userRequestDTO);
        validMailProvider(user.getEmail());
        verifyUserAge(user.getBirthday());
        return userMapper.getUserResponseDTO(userRepository.save(user));
    }

    public void deleteByEmail(String email) {
        var user = userRepository.findByEmail(email).orElseThrow(() -> new UserException("User with email " + email +
                " not found."));
        userRepository.delete(user);
    }

    private void validMailProvider(String mail) {
        Pattern patternProvedoresValidos = Pattern.compile("@gmail.com|@hotmail.com|@outlook.com|@yahoo.com");
        if (!patternProvedoresValidos.matcher(mail).find()) throw new EmailException("Only accepted" +
                " providers: Gmail, Hotmail, Outlook or Yahoo");
    }

    private void verifyUserAge(LocalDate birthDate) {
        if(Period.between(birthDate, LocalDate.now()).getYears()<18) throw new AgeException("Only accepted" +
                " users from 18 years of age");
    }

}
