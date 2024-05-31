package com.bezkoder.springjwt.service;

import com.bezkoder.springjwt.dto.UserDTO;
import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setFirstname(userDTO.getFirstname());
        user.setLastname(userDTO.getLastname());
        user.setEmail(userDTO.getEmail());
        user.setPhone(userDTO.getPhone());
        user.setIdCard(userDTO.getIdCard());
        user.setPassport(userDTO.getPassport());
        user.setCountry(userDTO.getCountry());
        user.setDate(userDTO.getDate());

        userRepository.save(user);

        return new UserDTO(user.getId(), user.getFirstname(), user.getLastname(), user.getEmail(),
                user.getPhone(), user.getIdCard(), user.getPassport(), user.getCountry(), user.getDate());
    }
}