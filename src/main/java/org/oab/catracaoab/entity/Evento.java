package org.oab.catracaoab.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String titulo;
    private String descricao;

    private LocalDateTime dataHoraEvento;

    @Column(unique = true)
    // Url do evento (titulo + uuid), ex: http://meusite.com/evento-oab-pjl-f63bdefa-4b8e-45e1-8b65-d0e7094c19f5
    private String slug;

    @OneToMany(mappedBy = "evento", cascade = CascadeType.ALL)
    private List<Participante> participantes;

}
