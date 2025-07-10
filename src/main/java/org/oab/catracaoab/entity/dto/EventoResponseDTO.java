package org.oab.catracaoab.entity.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class EventoResponseDTO {

    private UUID id;
    private String titulo;
    private String descricao;
    private LocalDateTime dataHoraEvento;
    private String slug;

}