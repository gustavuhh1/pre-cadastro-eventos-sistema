package org.oab.catracaoab.entity.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class CadastroVisitanteResponseDTO {
    private UUID id;
    private String nomeCompleto;
    private String cpf;
    private String email;
    private String telefone;

    private String eventoTitulo;
}
