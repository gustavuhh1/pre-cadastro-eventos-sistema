package org.oab.catracaoab.repository;

import org.oab.catracaoab.entity.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface EventoRepository extends JpaRepository<Evento, UUID> {
    Optional<Evento> findBySlug(String slug);
}