package org.oab.catracaoab.entity.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class CadastroVisitanteResponseDTO {
    private UUID id;
    private String nomeCompleto;
    private String cpf;
    private String imgFacialBase64;
    private String email;
    private String telefone;
    private StatusCadastro statusCadastro;

    private String eventoTitulo;
}
