package org.oab.catracaoab.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.oab.catracaoab.entity.dto.LoginRequestDTO;
import org.oab.catracaoab.entity.dto.LoginResponseDTO;
import org.oab.catracaoab.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody @Valid LoginRequestDTO loginDTO) {
        try {
            LoginResponseDTO response = authService.login(loginDTO);
            return ResponseEntity.ok(response);
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(401).body("Email ou senha inválidos");
        }
    }
}