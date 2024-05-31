package com.bezkoder.springjwt.service;

import com.bezkoder.springjwt.dto.UserDTO;
import com.bezkoder.springjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(user -> new UserDTO(user.getId(), user.getFirstname(), user.getLastname(), user.getEmail(),
                        user.getPhone(), user.getIdCard(), user.getPassport(), user.getCountry(), user.getDate()))
                .collect(Collectors.toList());
    }
}