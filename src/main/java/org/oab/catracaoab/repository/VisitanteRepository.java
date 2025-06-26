package org.oab.catracaoab.repository;

import org.oab.catracaoab.entity.Visitante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VisitanteRepository extends JpaRepository<Visitante, UUID> {
}