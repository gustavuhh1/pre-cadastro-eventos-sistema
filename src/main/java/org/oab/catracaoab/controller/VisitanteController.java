package org.oab.catracaoab.controller;

import lombok.RequiredArgsConstructor;
import org.oab.catracaoab.entity.dto.CadastroVisitanteRequestDTO;
import org.oab.catracaoab.entity.dto.CadastroVisitanteResponseDTO;
import org.oab.catracaoab.service.VisitanteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cadastro/visitante")
@RequiredArgsConstructor
public class VisitanteController {

    private final VisitanteService visitanteService;

    @PostMapping("/{slug}")
    public ResponseEntity<CadastroVisitanteResponseDTO> cadastrar(@PathVariable String slug, @RequestBody CadastroVisitanteRequestDTO visitante) {
        return ResponseEntity.ok(visitanteService.salvarVisitante(visitante, slug));
    }
}

