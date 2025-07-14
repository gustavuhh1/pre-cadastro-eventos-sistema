package org.oab.catracaoab.repository;

import org.oab.catracaoab.entity.Participante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ParticipanteRepository extends JpaRepository<Participante, UUID> {
    Optional<Participante> findByCpf(String cpf);
}
