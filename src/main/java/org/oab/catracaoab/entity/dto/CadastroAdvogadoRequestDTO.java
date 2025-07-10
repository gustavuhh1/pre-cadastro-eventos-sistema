package org.oab.catracaoab.entity.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CadastroAdvogadoRequestDTO {
    private String nomeCompleto;
    private String cpf;
    private String imgFacialBase64;

    private String numeroOAB;

    // Campos opcionais
    private LocalDate dataNascimento;
    private String telefone;
    private String email;
}
