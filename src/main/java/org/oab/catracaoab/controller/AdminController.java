package org.oab.catracaoab.controller;

import jakarta.validation.Valid;
import org.oab.catracaoab.entity.Admin;
import org.oab.catracaoab.entity.dto.AdminRequestDTO;
import org.oab.catracaoab.entity.dto.AdminResponseDTO;
import org.oab.catracaoab.service.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping
    public ResponseEntity<AdminRequestDTO> criarAdmin(@RequestBody @Valid AdminRequestDTO dto) {
        Admin adminCriado = adminService.criarAdmin(dto);

        AdminRequestDTO response = new AdminRequestDTO();
        response.setNome(adminCriado.getNome());
        response.setEmail(adminCriado.getEmail());
        response.setSenha(adminCriado.getSenha());

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<Admin>> listarAdmins() {

        List<Admin> listarAdmin = adminService.ListarAdmin();

        return  ResponseEntity.ok(listarAdmin);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdminResponseDTO> buscarAdminPorId(@PathVariable long id) {

        Admin admin = adminService.buscarPorId(id);

        AdminResponseDTO response = new AdminResponseDTO();
        response.setNome(admin.getNome());
        response.setEmail(admin.getEmail());

        return  ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdminResponseDTO> atualizarAdmin(@PathVariable long id, @RequestBody AdminRequestDTO dto) {

        Admin adminAtual = adminService.atualizarAdmin(id, dto);

        AdminResponseDTO response = new AdminResponseDTO();

        response.setNome(adminAtual.getNome());
        response.setEmail(adminAtual.getEmail());

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public void removerAdmin(@PathVariable long id) {
        adminService.excluirAdmin(id);

        ResponseEntity.noContent().build();
    }
}
