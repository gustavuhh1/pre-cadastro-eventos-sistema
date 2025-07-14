package org.oab.catracaoab.service;

import lombok.RequiredArgsConstructor;
import org.oab.catracaoab.entity.Participante;
import org.oab.catracaoab.entity.dto.StatusCadastro;
import org.oab.catracaoab.exception.RecursoNaoEncontradoException;
import org.oab.catracaoab.repository.EventoRepository;
import org.oab.catracaoab.repository.ParticipanteRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ControleEventoService {

    private final EventoRepository eventoRepository;
    private final ParticipanteRepository participanteRepository;

    public void aprovarParticipante(String cpf, String slugEvento) {
        eventoRepository.findBySlug(slugEvento).orElseThrow(() -> new RecursoNaoEncontradoException("Evento não encontrado"));

        Participante participante = participanteRepository.findByCpf(cpf)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Participante com CPF " + cpf + " não encontrado"));

        participante.setStatusCadastro(StatusCadastro.APROVADO);
        participanteRepository.save(participante);
    }

    public void recusarParticipante(String cpf, String slugEvento) {
        eventoRepository.findBySlug(slugEvento).orElseThrow(() -> new RecursoNaoEncontradoException("Evento não encontrado"));

        Participante participante = participanteRepository.findByCpf(cpf)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Participante com CPF " + cpf + " não encontrado"));

        participante.setStatusCadastro(StatusCadastro.RECUSADO);
        participanteRepository.save(participante);
    }
}
