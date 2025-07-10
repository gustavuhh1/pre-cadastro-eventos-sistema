package org.oab.catracaoab.controller;

import lombok.RequiredArgsConstructor;
import org.oab.catracaoab.entity.dto.CadastroAdvogadoRequestDTO;
import org.oab.catracaoab.entity.dto.CadastroAdvogadoResponseDTO;
import org.oab.catracaoab.service.AdvogadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cadastro/advogado")
@RequiredArgsConstructor
public class AdvogadoController {

    private final AdvogadoService advogadoService;

    @PostMapping("/{slug}")
    public ResponseEntity<CadastroAdvogadoResponseDTO> cadastrar(
            @PathVariable String slug,
            @RequestBody CadastroAdvogadoRequestDTO advogadoDTO) {

        CadastroAdvogadoResponseDTO response = advogadoService.salvarAdvogado(advogadoDTO, slug);
        return ResponseEntity.ok(response);
    }
}
