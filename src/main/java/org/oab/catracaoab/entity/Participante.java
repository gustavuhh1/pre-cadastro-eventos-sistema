package org.oab.catracaoab.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_participante")
@Getter
@Setter
public abstract class Participante {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nomeCompleto;

    @Column(unique=true)
    private String cpf;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String imgFacialBase64;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;


    // Opcionais por enquanto
    private LocalDate dataNascimento;
    private String telefone;
    private String email;

}
