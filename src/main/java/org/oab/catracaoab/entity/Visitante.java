package org.oab.catracaoab.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("VISITANTE")
public class Visitante extends Participante{
    // nenhum campo extra por enquanto!
}
