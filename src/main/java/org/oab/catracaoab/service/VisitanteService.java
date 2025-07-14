package org.oab.catracaoab.service;

import lombok.RequiredArgsConstructor;
import org.oab.catracaoab.entity.Evento;
import org.oab.catracaoab.entity.Visitante;
import org.oab.catracaoab.entity.dto.CadastroVisitanteRequestDTO;
import org.oab.catracaoab.entity.dto.CadastroVisitanteResponseDTO;
import org.oab.catracaoab.entity.dto.StatusCadastro;
import org.oab.catracaoab.exception.RecursoNaoEncontradoException;
import org.oab.catracaoab.repository.EventoRepository;
import org.oab.catracaoab.repository.VisitanteRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VisitanteService {

    private final VisitanteRepository visitanteRepository;
    private final EventoRepository eventoRepository;

    public CadastroVisitanteResponseDTO salvarVisitante(CadastroVisitanteRequestDTO dto, String slugEvento) {
        Evento evento = eventoRepository.findBySlug(slugEvento)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Evento não encontrado"));


        Visitante visitante = new Visitante();
        visitante.setNomeCompleto(dto.getNomeCompleto());
        visitante.setCpf(dto.getCpf());
        visitante.setImgFacialBase64(dto.getImgFacialBase64());
        visitante.setDataNascimento(dto.getDataNascimento());
        visitante.setTelefone(dto.getTelefone());
        visitante.setEmail(dto.getEmail());
        visitante.setEvento(evento);
        visitante.setStatusCadastro(StatusCadastro.PENDENTE);

        Visitante salvo = visitanteRepository.save(visitante);

        // Convertendo para DTO de resposta
        CadastroVisitanteResponseDTO response = new CadastroVisitanteResponseDTO();
        response.setId(salvo.getId());
        response.setNomeCompleto(salvo.getNomeCompleto());
        response.setImgFacialBase64(salvo.getImgFacialBase64());
        response.setCpf(salvo.getCpf());
        response.setEmail(salvo.getEmail());
        response.setTelefone(salvo.getTelefone());
        response.setStatusCadastro(salvo.getStatusCadastro());
        response.setEventoTitulo(evento.getTitulo());

        return response;
    }
}
