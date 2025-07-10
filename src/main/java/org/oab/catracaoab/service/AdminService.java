package org.oab.catracaoab.service;

import lombok.RequiredArgsConstructor;
import org.oab.catracaoab.entity.Admin;
import org.oab.catracaoab.entity.dto.AdminRequestDTO;
import org.oab.catracaoab.exception.RecursoNaoEncontradoException;
import org.oab.catracaoab.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminRepository adminRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Admin criarAdmin(AdminRequestDTO dto) {
        Admin admin = new Admin();
        admin.setNome(dto.getNome());
        admin.setEmail(dto.getEmail());
        admin.setSenha(passwordEncoder.encode(dto.getSenha()));

        return adminRepository.save(admin);
    }

    public void excluirAdmin(Long id){
        if(adminRepository.findById(id).isEmpty()){
            throw new RecursoNaoEncontradoException("Administrador com id:[" + id + "] não encontrado");
        }

        adminRepository.deleteById(id);
    }

    public Admin atualizarAdmin(Long id, AdminRequestDTO dto) {
        Admin adminExistente = adminRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Administrador com id:[" + id + "] não encontrado"));

        adminExistente.setNome(dto.getNome());
        adminExistente.setEmail(dto.getEmail());
        adminExistente.setSenha(dto.getSenha());

        return adminRepository.save(adminExistente);
    }

    public List<Admin> ListarAdmin() {
        return adminRepository.findAll();
    }

    public Admin buscarPorId(Long id) {
        return adminRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Administrador com id:[" + id + "] não encontrado"));
    }
}