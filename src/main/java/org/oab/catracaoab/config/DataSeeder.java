package org.oab.catracaoab.config;

import lombok.RequiredArgsConstructor;
import org.oab.catracaoab.entity.Admin;
import org.oab.catracaoab.entity.Evento;
import org.oab.catracaoab.repository.AdminRepository;
import org.oab.catracaoab.repository.EventoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final AdminRepository adminRepository;
    private final EventoRepository eventoRepository;
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

        String slugEvento = "evento-inaugural-oab-123teste";
        if (eventoRepository.findBySlug(slugEvento).isEmpty()) {
            Evento evento = new Evento();
            evento.setTitulo("Evento Inaugural OAB");
            evento.setDescricao("Este é o primeiro evento cadastrado no sistema, dedicado à advocacia local.");
            evento.setDataHoraEvento(LocalDateTime.now().plusDays(10).withHour(19).withMinute(0).withSecond(0));
            evento.setSlug(slugEvento);

            eventoRepository.save(evento);
            System.out.println("[✓] Evento fictício criado com sucesso.");
        } else {
            System.out.println("[i] Evento fictício já existe. Nenhuma ação tomada.");
        }
    }
}
