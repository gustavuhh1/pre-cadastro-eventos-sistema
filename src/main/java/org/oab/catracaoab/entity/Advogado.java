package org.oab.catracaoab.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("ADVOGADO")
@Getter
@Setter
public class Advogado extends Participante{

    @Column(unique = true)
    private String numeroOAB;
}
