package com.travelto.backend.service;

import com.travelto.backend.dto.UserDTO;
import com.travelto.backend.models.User;
import com.travelto.backend.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserDetailsService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

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

    @Transactional
    public void updatePassword(Long userId, String currentPassword, String newPassword) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(currentPassword, user.getPassword())) {
            throw new RuntimeException("Incorrect current password");
        }

        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
    }
}
