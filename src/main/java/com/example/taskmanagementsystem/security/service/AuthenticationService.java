package com.example.taskmanagementsystem.security.service;

import com.example.taskmanagementsystem.security.model.AuthenticationRequest;
import com.example.taskmanagementsystem.security.model.AuthenticationResponse;
import com.example.taskmanagementsystem.security.model.RegisterRequest;
import com.example.taskmanagementsystem.security.model.Role;
import com.example.taskmanagementsystem.security.model.User;
import com.example.taskmanagementsystem.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        User user = User.builder()
                .email(request.getEmail())
                .firstname(request.getFirstName())
                .lastname(request.getLastName())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        if (isExistAccount(user.getEmail())) {
            return AuthenticationResponse.builder()
                    .message(String.format("пользователь %s уже существует", request.getEmail()))
                    .build();
        }
        userRepository.save(user);
        String jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .message("регистрация пользователя прошла успешно")
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow(() -> new UsernameNotFoundException("user not found"));
        String jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse
                .builder()
                .token(jwtToken)
                .message("токен предоставлен")
                .build();
    }

    public boolean isExistAccount(String email) {
        return Objects.nonNull(getUserByEmail(email));
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }
}