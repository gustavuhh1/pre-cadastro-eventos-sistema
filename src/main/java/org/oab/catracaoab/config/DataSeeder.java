package org.oab.catracaoab.config;

import lombok.RequiredArgsConstructor;
import org.oab.catracaoab.entity.Admin;
import org.oab.catracaoab.repository.AdminRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        // Verifica se o admin fictício já existe
        String email = "admin@teste.com";
        if (adminRepository.findByEmail(email).isEmpty()) {
            Admin admin = new Admin();
            admin.setNome("Admin de Teste");
            admin.setEmail(email);
            admin.setSenha(passwordEncoder.encode("123456"));

            adminRepository.saveAndFlush(admin);

            System.out.println("[✓] Admin fictício criado com sucesso.");
        } else {
            System.out.println("[i] Admin fictício já existe. Nenhuma ação tomada.");
        }
    }
}
