package org.oab.catracaoab.entity.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EventoRequestDTO {

    @NotBlank(message = "O título é obrigatório")
    private String titulo;

    @NotBlank(message = "A descrição é obrigatória")
    private String descricao;

    @NotNull(message = "A data e hora do evento são obrigatórias")
    private LocalDateTime dataHoraEvento;

}