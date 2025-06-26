package org.oab.catracaoab.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@DiscriminatorValue("ADVOGADO")
public class Advogado extends Participante{

    @Column(unique = true)
    private String numeroOAB;
}
