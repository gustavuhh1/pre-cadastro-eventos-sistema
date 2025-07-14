package org.oab.catracaoab.controller;

import org.oab.catracaoab.entity.Participante;
import org.oab.catracaoab.entity.dto.DashboardResponseDTO;
import org.oab.catracaoab.entity.dto.StatusCadastro;
import org.oab.catracaoab.repository.EventoRepository;
import org.oab.catracaoab.repository.ParticipanteRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    EventoRepository eventoRepository;
    ParticipanteRepository participanteRepository;

    public DashboardController(EventoRepository eventoRepository, ParticipanteRepository participanteRepository) {
        this.eventoRepository = eventoRepository;
        this.participanteRepository = participanteRepository;
    }

    @GetMapping()
    public DashboardResponseDTO retornaQuantidadeEventos() {


        int eventosTotal =  eventoRepository.findAll().size();
        List<Participante> users = participanteRepository.findAll();

        int usuariosTotal = users.size();
        long usuariosPendenteTotal = users.stream()
                .filter(p -> p.getStatusCadastro() == StatusCadastro.PENDENTE)
                .count();
        long usuariosAprovadoTotal = users.stream()
                .filter(p -> p.getStatusCadastro() == StatusCadastro.APROVADO)
                .count();

        eventoRepository.count();

        return new DashboardResponseDTO(eventosTotal, usuariosTotal, usuariosPendenteTotal, usuariosAprovadoTotal);
    }
}
