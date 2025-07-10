package org.oab.catracaoab.service;

import lombok.RequiredArgsConstructor;
import org.oab.catracaoab.entity.Evento;
import org.oab.catracaoab.entity.dto.EventoRequestDTO;
import org.oab.catracaoab.exception.RecursoNaoEncontradoException;
import org.oab.catracaoab.repository.EventoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EventoService {

    private final EventoRepository eventoRepository;

    public Evento criarEvento(EventoRequestDTO dto) {
        Evento evento = new Evento();
        evento.setTitulo(dto.getTitulo());
        evento.setDescricao(dto.getDescricao());
        evento.setDataHoraEvento(dto.getDataHoraEvento());
        evento.setSlug(gerarSlug(dto.getTitulo()));

        return eventoRepository.save(evento);
    }

    public Evento buscarPorSlug(String slug) {
        return eventoRepository.findBySlug(slug)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Evento com slug '" + slug + "' não encontrado"));
    }

    public void excluirEvento(UUID id){
        if(eventoRepository.findById(id).isEmpty()){
            throw new RecursoNaoEncontradoException("Evento com slug '" + id + "' não encontrado");
        }

        eventoRepository.deleteById(id);
    }

    public Evento atualizarEvento(UUID id, EventoRequestDTO dto) {
        Evento eventoExistente = eventoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Evento com ID " + id + " não encontrado"));

        eventoExistente.setTitulo(dto.getTitulo());
        eventoExistente.setDescricao(dto.getDescricao());
        eventoExistente.setDataHoraEvento(dto.getDataHoraEvento());

        return eventoRepository.save(eventoExistente);
    }

    public List<Evento> buscarTodos() {
        return eventoRepository.findAll();
    }

    private String gerarSlug(String titulo) {
        String base = titulo.toLowerCase().replaceAll("[^a-z0-9]", "-");
        return base + "-" + UUID.randomUUID().toString().substring(0, 8);
    }
}
