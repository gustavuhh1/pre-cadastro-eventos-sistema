package org.oab.catracaoab.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.oab.catracaoab.entity.Evento;
import org.oab.catracaoab.entity.dto.EventoRequestDTO;
import org.oab.catracaoab.entity.dto.EventoResponseDTO;
import org.oab.catracaoab.service.EventoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/eventos")
@RequiredArgsConstructor
public class EventoController {

    private final EventoService eventoService;

    @PostMapping
    public ResponseEntity<EventoResponseDTO> criarEvento(@RequestBody @Valid EventoRequestDTO dto) {
        Evento criado = eventoService.criarEvento(dto);

        EventoResponseDTO response = new EventoResponseDTO();
        response.setId(criado.getId());
        response.setTitulo(criado.getTitulo());
        response.setDescricao(criado.getDescricao());
        response.setDataHoraEvento(criado.getDataHoraEvento());
        response.setSlug(criado.getSlug());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{slug}")
    public ResponseEntity<Evento> buscarPorSlug(@PathVariable String slug) {
        Evento evento = eventoService.buscarPorSlug(slug);

        return ResponseEntity.ok(evento);
    }

    @GetMapping
    public ResponseEntity<List<Evento>> buscarTodos() {
        return ResponseEntity.ok(eventoService.buscarTodos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventoResponseDTO> atualizarEvento(
            @PathVariable UUID id,
            @RequestBody @Valid EventoRequestDTO dto) {

        Evento atualizado = eventoService.atualizarEvento(id, dto);

        EventoResponseDTO response = new EventoResponseDTO();
        response.setId(atualizado.getId());
        response.setTitulo(atualizado.getTitulo());
        response.setDescricao(atualizado.getDescricao());
        response.setDataHoraEvento(atualizado.getDataHoraEvento());
        response.setSlug(atualizado.getSlug());

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerEvento(@PathVariable UUID id) {
        eventoService.excluirEvento(id);

        return ResponseEntity.noContent().build();
    }
}


