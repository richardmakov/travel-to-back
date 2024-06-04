package com.travelto.backend.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.travelto.backend.payload.request.LoginRequest;
import com.travelto.backend.payload.request.SignupRequest;
import com.travelto.backend.payload.response.JwtResponse;
import com.travelto.backend.payload.response.MessageResponse;
import com.travelto.backend.repository.RoleRepository;
import com.travelto.backend.repository.UserRepository;
import com.travelto.backend.security.jwt.JwtUtils;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.travelto.backend.models.ERole;
import com.travelto.backend.models.Role;
import com.travelto.backend.models.User;
import com.travelto.backend.security.services.UserDetailsImpl;

@CrossOrigin(originPatterns = "*")
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(
                jwt,
                userDetails.getFirstname(),
                userDetails.getLastname(),
                userDetails.getPhone(),
                userDetails.getIdCard(),
                userDetails.getPassport(),
                userDetails.getCountry(),
                userDetails.getId(),
                userDetails.getEmail(),
                roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {

        if (userRepository.existsByPassport(signUpRequest.getPassport())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Passport is already in use!"));
        }

        if (userRepository.existsByIdCard(signUpRequest.getIdCard())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: IdCard is already in use!"));
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }


        // Create new user's account
        User user = new User(signUpRequest.getFirstname(), signUpRequest.getLastname(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()), signUpRequest.getPhone(), signUpRequest.getIdCard(), signUpRequest.getPassport(), signUpRequest.getCountry(), signUpRequest.getDate());

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);
                        break;
                    case "mod":
                        Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(modRole);
                        break;
                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }

        user.setRoles(roles);
        userRepository.save(user);

        // Automatically log in the user after successful registration
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signUpRequest.getEmail(), signUpRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> userRoles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(
                jwt,
                userDetails.getFirstname(),
                userDetails.getLastname(),
                userDetails.getPhone(),
                userDetails.getIdCard(),
                userDetails.getPassport(),
                userDetails.getCountry(),
                userDetails.getId(),
                userDetails.getEmail(),
                userRoles));
    }

}
