package org.oab.catracaoab.repository;

import org.oab.catracaoab.entity.Advogado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AdvogadoRepository extends JpaRepository<Advogado, UUID> {
    Optional<Advogado> findByNumeroOab(String numeroOab);
}