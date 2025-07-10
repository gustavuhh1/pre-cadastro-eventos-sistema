package org.oab.catracaoab.service;


import lombok.RequiredArgsConstructor;
import org.oab.catracaoab.config.JwtUtil;
import org.oab.catracaoab.entity.Admin;
import org.oab.catracaoab.entity.dto.LoginRequestDTO;
import org.oab.catracaoab.entity.dto.LoginResponseDTO;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public LoginResponseDTO login(LoginRequestDTO loginDTO) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getSenha())
            );

            Admin admin = (Admin) authentication.getPrincipal();
            String token = jwtUtil.generateToken(admin.getEmail());

            return new LoginResponseDTO(admin.getNome(), admin.getEmail(), token);
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("Email ou senha inválidos");
        }
    }
}
