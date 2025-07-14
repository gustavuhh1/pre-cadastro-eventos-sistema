package org.oab.catracaoab.service;

import lombok.RequiredArgsConstructor;
import org.oab.catracaoab.entity.Advogado;
import org.oab.catracaoab.entity.Evento;
import org.oab.catracaoab.entity.dto.CadastroAdvogadoRequestDTO;
import org.oab.catracaoab.entity.dto.CadastroAdvogadoResponseDTO;
import org.oab.catracaoab.entity.dto.StatusCadastro;
import org.oab.catracaoab.exception.RecursoNaoEncontradoException;
import org.oab.catracaoab.repository.AdvogadoRepository;
import org.oab.catracaoab.repository.EventoRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdvogadoService {

    private final AdvogadoRepository advogadoRepository;
    private final EventoRepository eventoRepository;

    public CadastroAdvogadoResponseDTO salvarAdvogado(CadastroAdvogadoRequestDTO dto, String slugEvento) {
        Evento evento = eventoRepository.findBySlug(slugEvento)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Evento não encontrado"));

        Advogado advogado = new Advogado();
        advogado.setNomeCompleto(dto.getNomeCompleto());
        advogado.setCpf(dto.getCpf());
        advogado.setNumeroOAB(dto.getNumeroOAB());
        advogado.setImgFacialBase64(dto.getImgFacialBase64());
        advogado.setDataNascimento(dto.getDataNascimento());
        advogado.setTelefone(dto.getTelefone());
        advogado.setEmail(dto.getEmail());
        advogado.setStatusCadastro(StatusCadastro.PENDENTE);
        advogado.setEvento(evento);

        Advogado salvo = advogadoRepository.save(advogado);

        CadastroAdvogadoResponseDTO response = new CadastroAdvogadoResponseDTO();
        response.setId(salvo.getId());
        response.setNomeCompleto(salvo.getNomeCompleto());
        response.setNumeroOAB(salvo.getNumeroOAB());
        response.setCpf(salvo.getCpf());
        response.setEmail(salvo.getEmail());
        response.setStatusCadastro(salvo.getStatusCadastro());
        response.setEventoTitulo(evento.getTitulo());

        return response;
    }
}
