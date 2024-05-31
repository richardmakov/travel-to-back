package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.dto.UserDTO;
import com.bezkoder.springjwt.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserDetailsService userDetailsService;

    @GetMapping("/all")
    public List<UserDTO> getAllUsers() {
        return userDetailsService.getAllUsers();
    }
}
