package com.travelto.backend.controllers;

import com.travelto.backend.dto.UserDTO;
import com.travelto.backend.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(originPatterns = "*")
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserDetailsService userDetailsService;

    @GetMapping("/all")
    public List<UserDTO> getAllUsers() {
        return userDetailsService.getAllUsers();
    }

    @PutMapping("/update/{id}")
    public UserDTO updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        return userDetailsService.updateUser(id, userDTO);
    }
    @PutMapping("/updatePassword/{userId}")
    public ResponseEntity<String> updatePassword(@PathVariable Long userId,
                                                 @RequestParam String currentPassword,
                                                 @RequestParam String newPassword) {
        userDetailsService.updatePassword(userId, currentPassword, newPassword);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
